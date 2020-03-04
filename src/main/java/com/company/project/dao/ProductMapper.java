package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Product;
import com.company.project.model.ProductPo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {

    @Results(
            id = "productPoResult",value = {
            @Result(property = "pid",column = "pid",id = true),
            @Result(property = "productName",column = "product_name"),
            @Result(property = "type_name",column = "typeName"),
            @Result(property = "url",column = "url"),
    }
    )
    @Select("SELECT product.PRODUCT_NAME, product.URL, types.TYPE_NAME\n" +
            "    FROM product,types\n" +
            "    WHERE product.pid IN (SELECT pid FROM product_types WHERE types.tid = product_types.tid);")
    public List<ProductPo> getProductPoList();
}