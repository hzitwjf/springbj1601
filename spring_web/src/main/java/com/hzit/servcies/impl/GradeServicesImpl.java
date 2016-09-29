package com.hzit.servcies.impl;

import com.hzit.dao.entity.Grade;
import com.hzit.dao.mapper.GradeMapper;
import com.hzit.servcies.GradeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@Service
public class GradeServicesImpl implements GradeServices {
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<Grade> findAll() {

        return gradeMapper.searchGradeByParams(null);
    }
}
