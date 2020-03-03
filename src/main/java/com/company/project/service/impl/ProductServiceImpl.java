package com.company.project.service.impl;

import com.company.project.dao.ProductMapper;
import com.company.project.model.Product;
import com.company.project.service.ProductService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/03.
 */
@Service
@Transactional
public class ProductServiceImpl extends AbstractService<Product> implements ProductService {
    @Resource
    private ProductMapper productMapper;

}
