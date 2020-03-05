package com.company.project.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Product;
import com.company.project.model.ProductPo;
import com.company.project.model.ProductTypes;
import com.company.project.model.Types;
import com.company.project.service.ProductPoService;
import com.company.project.service.ProductService;
import com.company.project.service.ProductTypesService;
import com.company.project.service.TypesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 *
 * 控制 农业产品功能
* Created by  on 2020/03/04.
*/
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private TypesService typesService;

    @Resource
    private ProductPoService productPoService;

    @Resource
    private ProductTypesService productTypesService;

//    新增
    @PostMapping("/add")
    public Result add(@RequestParam(value = "productName",required = true) String productName,
                      @RequestParam(value = "url",required = true) String url,
                      @RequestParam(value = "typeName",required = true) String typeName) {
        Product product = new Product();//设置数据
        product.setProductName(productName);//设置数据
        product.setUrl(url);//设置数据
        product.setProductTime(new Date());//设置数据
        productService.save(product);//往数据库中存储产品

        int pid = productService.findBy("productName",productName).getPid(); //查询种类ID
        Types types = typesService.findBy("typeName",typeName);//查询种类ID

        ProductTypes productTypes = new ProductTypes(pid,types.getTid()); //设置农业产品和种类关系
        productTypesService.save(productTypes);//往数据库中存储农业产品和种类关系

        return ResultGenerator.genSuccessResult("添加成功");
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        productService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Product product) {
        productService.update(product);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Product product = productService.findById(id);
        return ResultGenerator.genSuccessResult(product);
    }

    @PostMapping("/get")
    public Object getlist() {
        Gson gson = new Gson();
//        这里有一个json坑（这个不用管）
        List<ProductPo> list = productPoService.getProductPoList();

        PageInfo pageInfo = new PageInfo(list);

        return JSONObject.parse(gson.toJson(ResultGenerator.genSuccessResult(pageInfo))) ;

    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Product> list = productService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
