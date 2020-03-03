package com.company.project.service.impl;

import com.company.project.dao.TypesMapper;
import com.company.project.model.Types;
import com.company.project.service.TypesService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/03.
 */
@Service
@Transactional
public class TypesServiceImpl extends AbstractService<Types> implements TypesService {
    @Resource
    private TypesMapper typesMapper;

}
