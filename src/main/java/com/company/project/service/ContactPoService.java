package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Contact;
import com.company.project.model.ContactPo;
import com.company.project.model.IntroducePo;

import java.util.List;


/**
 * Created by  on 2020/03/08.
 */
public interface ContactPoService extends Service<ContactPo> {

    public List<ContactPo> getContactPoList();
}
