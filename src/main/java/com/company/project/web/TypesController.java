package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Types;
import com.company.project.service.ProductTypesService;
import com.company.project.service.TypesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 *产品类型控制文件
* Created by  on 2020/03/04.
*/
@RestController
@RequestMapping("/types")
public class TypesController {
    @Resource
    private TypesService typesService;

    @Resource
    private ProductTypesService productTypesService;


   //类型新增接口
    @PostMapping("/add")
    public Result add(@RequestBody Map<String,String> data) {
        Types types = new Types();
        types.setDescribes(data.get("describe"));
        types.setTypeName( data.get("typeName"));
        types.setTypeTime(new  Date());//设置属性
        typesService.save(types);  // 往数据库中存储数据
        return ResultGenerator.genSuccessResult();  //返回结果
    }

    //删除类型接口
    @PostMapping("/delete")
    public Result delete(@RequestBody Map<String,Integer> data) { //函数名
        productTypesService.deleteById(productTypesService.findBy("tid",data.get("id")).getPid());
        typesService.deleteById(data.get("id"));  //从数据库中删除数据
        return ResultGenerator.genSuccessResult();//返回结果
    }

    //修改类型接口
    @PostMapping("/update")
    public Result update(@RequestBody Map<String,Object> data) {//函数名
        Types types = new Types();
        types.setTid((Integer) data.get("tid"));
        types.setDescribes((String) data.get("describe"));
        types.setTypeName((String) data.get("typeName"));
        types.setTypeTime(new  Date());//设置属性
        typesService.update(types); //修改数据库中的数据
        return ResultGenerator.genSuccessResult();//返回结果
    }



    //查询一个所有的类型
    @PostMapping("/list")
    public Result list() {
        List<Types> list = typesService.findAll();//从数据库中查询所有产品类型
        return ResultGenerator.genSuccessResult(list);//返回数据
    }
}
