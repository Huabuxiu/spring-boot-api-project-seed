package com.company.project.service.impl;

import com.company.project.dao.ProductTypesMapper;
import com.company.project.model.ProductTypes;
import com.company.project.service.ProductTypesService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/04.
 */
@Service
@Transactional
public class ProductTypesServiceImpl extends AbstractService<ProductTypes> implements ProductTypesService {
    @Resource
    private ProductTypesMapper productTypesMapper;

}
