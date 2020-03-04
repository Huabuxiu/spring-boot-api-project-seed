package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ProductMapper;
import com.company.project.dao.ProductPoMapper;
import com.company.project.model.Product;
import com.company.project.model.ProductPo;
import com.company.project.service.ProductPoService;
import com.company.project.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by  on 2020/03/04.
 */
@Service
@Transactional
public class ProductPoServiceImpl extends AbstractService<ProductPo> implements ProductPoService {

    @Resource
    private ProductPoMapper productPoMapper;

    public List<ProductPo> getProductPoList(){
        List<ProductPo> productPoList = new ArrayList<>();
        productPoList = productPoMapper.getProductPoList();
        return productPoList;
    }

}
