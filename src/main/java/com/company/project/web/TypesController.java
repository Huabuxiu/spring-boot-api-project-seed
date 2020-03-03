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
import java.util.List;

/**
* Created by  on 2020/03/03.
*/
@RestController
@RequestMapping("/types")
public class TypesController {
    @Resource
    private TypesService typesService;

    @PostMapping("/add")
    public Result add(Types types) {
        typesService.save(types);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        typesService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Types types) {
        typesService.update(types);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Types types = typesService.findById(id);
        return ResultGenerator.genSuccessResult(types);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Types> list = typesService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
