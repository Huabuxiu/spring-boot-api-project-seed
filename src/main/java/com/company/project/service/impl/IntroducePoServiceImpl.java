package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.IntroduceMapper;
import com.company.project.dao.IntroducePoMapper;
import com.company.project.model.Introduce;
import com.company.project.model.IntroducePo;
import com.company.project.service.IntroducePoService;
import com.company.project.service.IntroduceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class IntroducePoServiceImpl extends AbstractService<IntroducePo> implements IntroducePoService {
    @Resource
    private IntroducePoMapper introducePoMapper;

    @Override
    public List<IntroducePo> getIntroducePoList() {
        List<IntroducePo> list = new ArrayList<>();
        list = introducePoMapper.getIntroducePoList();
        return list;
    }
}
