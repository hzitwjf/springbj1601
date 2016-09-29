package com.hzit.servcies;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Student;
import com.hzit.dao.vo.StudentVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/27.
 */

public interface StudentServcies {
    List<StudentVo> findAll(Map map);
    Page<StudentVo> findPage(int page,int rowCount );
    int insert(Student student);
    int delete(Integer studentNo);
    int update(Student student);
    Student finnById(Integer studentNo);
    StudentVo findById(Integer studentNo);
}
