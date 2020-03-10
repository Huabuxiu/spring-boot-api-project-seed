package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CompanyMessage;
import com.company.project.model.Introduce;
import com.company.project.model.IntroduceCm;
import com.company.project.model.IntroducePo;
import com.company.project.service.CompanyMessageService;
import com.company.project.service.IntroduceCmService;
import com.company.project.service.IntroducePoService;
import com.company.project.service.IntroduceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by  on 2020/03/08.
*/
@RestController
@RequestMapping("/introduce")
public class IntroduceController {
    @Resource
    private IntroduceService introduceService;

    @Resource
    private IntroducePoService introducePoService;

    @Resource
    private IntroduceCmService introduceCmService;

    @Resource
    CompanyMessageService companyMessageService;

    @PostMapping("/update")
    public Result update(@RequestBody Map<String,String> data) {
        Introduce introduce = new Introduce();
        introduce.setIid(introducePoService.getIntroducePoList().get(0).getIid());
        introduce.setCompanyIntroduce(data.get("companyIntroduce"));
        introduce.setLogo(data.get("logo"));
        introduce.setManagementModel(data.get("managementModel"));
        introduceService.update(introduce);
        CompanyMessage companyMessage = companyMessageService.findAll().get(0);
        companyMessage.setCompanyName(data.get("companyName"));
        companyMessage.setContacts(data.get("contacts"));
        companyMessageService.update(companyMessage);
        introduceCmService.update(new IntroduceCm(introduce.getIid(),companyMessage.getCmid()));
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/list")
    public Result list() {
        List<IntroducePo> list = introducePoService.getIntroducePoList();
        return ResultGenerator.genSuccessResult(list);
    }
}
