package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.IntroducePo;

import java.util.List;

public interface IntroducePoMapper extends Mapper<IntroducePo> {

    public List<IntroducePo> getIntroducePoList();
}