package com.company.project.web;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.News;
import com.company.project.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 农业新闻功能管理
* Created by  on 2020/03/03.
*/
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    private NewsService newsService;

    //新增新闻
    @PostMapping("/add")
    public Result add(@RequestBody Map<String,String> data ) {

        if (data.get("newsTitle")==null) {
            return ResultGenerator.genFailResult("缺少新闻标题");
        }
        if (data.get("url")==null) {
            return ResultGenerator.genFailResult("缺少新闻链接");
        }
        News news = new News();
        news.setNewsTitle(data.get("newsTitle"));
        news.setUrl(data.get("url"));
        news.setTypeTime(new Date());
        newsService.save(news);//往数据库中插入新闻数据
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Map<String,Integer> data) {
        newsService.deleteById(data.get("id"));
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Map<String,Object> data) {

        if (data.get("nid") == null){
            return ResultGenerator.genSuccessResult("缺少id");
        }
        News news = new News();
        news.setNid((Integer) data.get("nid"));
        news.setNewsTitle((String) data.get("newsTitle"));
        news.setUrl((String) data.get("url"));
        news.setTypeTime(new Date());
        newsService.update(news);
        return ResultGenerator.genSuccessResult();
    }


    @PostMapping("/list")
    public Result list() {
        List<News> list = newsService.findAll();
        return ResultGenerator.genSuccessResult(list);
    }
}
