package com.company.project.service.impl;

import com.company.project.dao.IntroduceMapper;
import com.company.project.model.Introduce;
import com.company.project.service.IntroduceService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class IntroduceServiceImpl extends AbstractService<Introduce> implements IntroduceService {
    @Resource
    private IntroduceMapper introduceMapper;

}
