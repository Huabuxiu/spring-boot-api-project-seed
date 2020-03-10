package com.company.project.service.impl;

import com.company.project.dao.ContactCmMapper;
import com.company.project.model.ContactCm;
import com.company.project.service.ContactCmService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class ContactCmServiceImpl extends AbstractService<ContactCm> implements ContactCmService {
    @Resource
    private ContactCmMapper contactCmMapper;

}
