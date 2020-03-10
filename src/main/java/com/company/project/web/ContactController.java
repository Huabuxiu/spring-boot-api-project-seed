package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CompanyMessage;
import com.company.project.model.Contact;
import com.company.project.model.ContactCm;
import com.company.project.model.ContactPo;
import com.company.project.service.CompanyMessageService;
import com.company.project.service.ContactCmService;
import com.company.project.service.ContactPoService;
import com.company.project.service.ContactService;
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
@RequestMapping("/contact")
public class ContactController {
    @Resource
    private ContactService contactService;

    @Resource
    private ContactPoService contactPoService;

    @Resource
    private ContactCmService contactCmService;

    @Resource
    private CompanyMessageService companyMessageService;

    @PostMapping("/update")
    public Result update(@RequestBody Map<String,String> data) {
        Contact contact = new Contact();
        contact.setCid(contactPoService.getContactPoList().get(0).getCid());
        contact.setAddress(data.get("address"));
        contact.seteMail(data.get("eMail"));
        contact.setFax(data.get("fax"));
        contact.setPhone(data.get("phone"));
        contact.setQq(data.get("qq"));
        contact.setTelephone(data.get("telephone"));
        contact.setZipCode(data.get("zipCode"));
        contactService.update(contact);
        CompanyMessage companyMessage = companyMessageService.findBy("companyName",data.get("companyName"));
        companyMessage.setCompanyName(data.get("companyName"));
        companyMessage.setContacts(data.get("contacts"));
        companyMessageService.update(companyMessage);
        contactCmService.update(new ContactCm(contact.getCid(),companyMessage.getCmid()));
        return ResultGenerator.genSuccessResult("更新成功");
    }



    @PostMapping("/list")
    public Result list() {
        List<ContactPo> list = contactPoService.getContactPoList();
        return ResultGenerator.genSuccessResult(list);
    }
}
