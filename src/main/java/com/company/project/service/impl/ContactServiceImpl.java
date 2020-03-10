package com.company.project.service.impl;

import com.company.project.dao.ContactMapper;
import com.company.project.model.Contact;
import com.company.project.service.ContactService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class ContactServiceImpl extends AbstractService<Contact> implements ContactService {
    @Resource
    private ContactMapper contactMapper;

}
