package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Contact;
import com.company.project.service.ContactService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 控制联系我们功能
* Created by  on 2020/03/03.
*/
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Resource
    private ContactService contactService;

//   新增联系我们
    @PostMapping("/add")
    public Result add(Contact contact) {
        contactService.save(contact);//存数据库
        return ResultGenerator.genSuccessResult();//返回结果
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        contactService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Contact contact) {
        contactService.update(contact);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Contact contact = contactService.findById(id);
        return ResultGenerator.genSuccessResult(contact);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Contact> list = contactService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
