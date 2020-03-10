package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Contact;
import com.company.project.model.ContactPo;
import com.company.project.model.ProductPo;

import java.util.List;

public interface ContactPoMapper extends Mapper<ContactPo> {
    public List<ContactPo> getContactPoList();
}