package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Types;
import com.company.project.service.TypesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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


   //类型新增接口
    @PostMapping("/add")
    public Result add(@RequestParam(value = "typeName",required = true) String typeName, //函数名
                      @RequestParam(value = "describes",required = true) String describes) {
        Types types = new Types();  //设置属性
        types.setTypeName(typeName);//设置属性
        types.setDescribes(describes);//设置属性
        Date date = new  Date();
        types.setTypeTime(new  Date(date.getTime()));//设置属性
        typesService.save(types);  // 往数据库中存储数据
        return ResultGenerator.genSuccessResult();  //返回结果
    }

    //删除类型接口
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) { //函数名
        typesService.deleteById(id);  //从数据库中删除数据
        return ResultGenerator.genSuccessResult();//返回结果
    }

    //修改类型接口
    @PostMapping("/update")
    public Result update(Types types) {//函数名
        typesService.update(types); //修改数据库中的数据
        return ResultGenerator.genSuccessResult();//返回结果
    }

    //查询一个产品类型
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {//函数名
        Types types = typesService.findById(id);//从数据库中查询一个产品类型
        return ResultGenerator.genSuccessResult(types);
    }

    //查询一个所有的类型
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);//设置分页工具
        List<Types> list = typesService.findAll();//从数据库中查询所有产品类型
        PageInfo pageInfo = new PageInfo(list);//数据分页
        return ResultGenerator.genSuccessResult(pageInfo);//返回数据
    }
}
