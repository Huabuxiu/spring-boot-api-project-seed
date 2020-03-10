package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ContactPoMapper;

import com.company.project.model.ContactPo;
import com.company.project.service.ContactPoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class ContactPoServiceImpl extends AbstractService<ContactPo> implements ContactPoService {

    @Resource
    private ContactPoMapper ContactPoMapper;

    @Override
    public List<ContactPo> getContactPoList() {
        List<ContactPo> list = new ArrayList<>();
        list = ContactPoMapper.getContactPoList();
        return list;
    }
}
