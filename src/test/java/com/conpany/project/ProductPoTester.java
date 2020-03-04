package com.conpany.project;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.project.Application;
import com.company.project.model.ProductPo;
import com.company.project.service.ProductPoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public abstract class ProductPoTester {
    @Autowired
    private ProductPoService productPoService;

    public void  test(){

       List<ProductPo> list =  productPoService.getProductPoList();
        for (ProductPo po : list
             ) {
            System.out.println(JSONObject.toJSON(po));
        }
    }

}



