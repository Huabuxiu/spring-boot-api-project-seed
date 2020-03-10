package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 控制用户登录
* Created by  on 2020/03/03.
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


//登录
    @PostMapping("/login")
    public Result login(User user) {
        User userTable = userService.findBy("username",user.getUsername());
        String  state = "longin";
        if (userTable==null){
            return ResultGenerator.genFailResult("用户不存在");
        }else if (userTable.getPassword().equals (user.getPassword())){
            return ResultGenerator.genFailResult("用户名密码错误");
        }
        return ResultGenerator.genSuccessResult(state);
    }

//    新增
    @PostMapping("/add")
    public Result add(User user) {
        userService.save(user);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(User user) {
        userService.update(user);
        return ResultGenerator.genSuccessResult();
    }




}
