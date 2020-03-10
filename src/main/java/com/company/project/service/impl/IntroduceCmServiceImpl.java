package com.company.project.service.impl;

import com.company.project.dao.IntroduceCmMapper;
import com.company.project.model.IntroduceCm;
import com.company.project.service.IntroduceCmService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by  on 2020/03/08.
 */
@Service
@Transactional
public class IntroduceCmServiceImpl extends AbstractService<IntroduceCm> implements IntroduceCmService {
    @Resource
    private IntroduceCmMapper introduceCmMapper;

}
