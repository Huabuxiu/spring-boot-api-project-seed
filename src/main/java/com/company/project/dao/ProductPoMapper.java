package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ProductPo;


import java.util.List;


public interface ProductPoMapper  extends Mapper<ProductPo>  {


    public List<ProductPo> getProductPoList();
}