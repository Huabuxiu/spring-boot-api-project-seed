package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.News;
import com.company.project.model.Product;
import com.company.project.model.ProductPo;
import com.company.project.model.ProductTypes;
import com.company.project.service.ProductPoService;
import com.company.project.service.ProductService;
import com.company.project.service.ProductTypesService;
import com.company.project.service.TypesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* Created by  on 2020/03/08.
*/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private ProductPoService productPoService;

    @Resource
    private ProductTypesService productTypesService;

    @Resource
    private TypesService typesService;

    @PostMapping("/add")
    public Result add(@RequestBody Map<String,String> data ) {
        Product product = new Product();
        product.setProductName(data.get("productName"));
        product.setUrl(data.get("url"));
        product.setProductTime(new Date());

        if (typesService.findBy("typeName",data.get("typeName")) == null){
            return ResultGenerator.genFailResult("种类不存在");
        }
        productService.save(product);
        productTypesService.save(new ProductTypes(
                productService.findBy("productName",product.getProductName()).getPid(),
                typesService.findBy("typeName",data.get("typeName")).getTid()));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Map<String,Integer> data) {
        productTypesService.deleteById(data.get("id"));
        productService.deleteById(data.get("id"));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Map<String,String> data) {
        if (data.get("pid")== null){
            return ResultGenerator.genFailResult("缺少id");
        }
        Product product = new Product();
        product.setPid(Integer.parseInt(data.get("pid")));
        product.setProductName(data.get("productName"));
        product.setUrl(data.get("url"));
        product.setProductTime(new Date());
        if (typesService.findBy("typeName",data.get("typeName")) == null){
            return ResultGenerator.genFailResult("种类不存在");
        }
        productService.update(product);
        productTypesService.update(new ProductTypes(product.getPid(),
                                                    typesService.findBy("typeName",data.get("typeName"))
                                                            .getTid()));
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/get")
    public Result list() {
        List<ProductPo> list = productPoService.getProductPoList();
        return ResultGenerator.genSuccessResult(list);
    }
}
