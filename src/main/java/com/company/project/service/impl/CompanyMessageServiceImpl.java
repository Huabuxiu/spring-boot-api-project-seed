package com.company.project.service.impl;

import com.company.project.dao.CompanyMessageMapper;
import com.company.project.model.CompanyMessage;
import com.company.project.service.CompanyMessageService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class CompanyMessageServiceImpl extends AbstractService<CompanyMessage> implements CompanyMessageService {
    @Resource
    private CompanyMessageMapper companyMessageMapper;

}
