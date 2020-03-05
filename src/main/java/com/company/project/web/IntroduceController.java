package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Introduce;
import com.company.project.service.IntroduceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制公司介绍功能
* Created by  on 2020/03/03.
*/
@RestController
@RequestMapping("/introduce")
public class IntroduceController {
    @Resource
    private IntroduceService introduceService;

//    新增
    @PostMapping("/add")
    public Result add(Introduce introduce) {
        introduceService.save(introduce); //插入数据库
        return ResultGenerator.genSuccessResult();//返回结果
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        introduceService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Introduce introduce) {
        introduceService.update(introduce);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Introduce introduce = introduceService.findById(id);
        return ResultGenerator.genSuccessResult(introduce);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Introduce> list = introduceService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
