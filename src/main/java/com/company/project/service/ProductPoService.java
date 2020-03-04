package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Product;
import com.company.project.model.ProductPo;

import java.util.List;


/**
 * Created by  on 2020/03/04.
 */
public interface ProductPoService extends Service<ProductPo> {

    public List<ProductPo> getProductPoList();

}
