package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.Introduce;
import com.company.project.model.IntroducePo;
import com.company.project.model.ProductPo;

import java.util.List;


/**
 * Created by  on 2020/03/08.
 */
public interface IntroducePoService extends Service<IntroducePo> {

    public List<IntroducePo> getIntroducePoList();

}
