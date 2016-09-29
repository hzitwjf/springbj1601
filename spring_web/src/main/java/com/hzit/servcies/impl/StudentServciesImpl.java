package com.hzit.servcies.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.dao.entity.Student;
import com.hzit.dao.mapper.GradeMapper;
import com.hzit.dao.mapper.StudentMapper;
import com.hzit.dao.vo.StudentVo;
import com.hzit.servcies.StudentServcies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/27.
 */
@Service
public class StudentServciesImpl implements StudentServcies {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<StudentVo> findAll(Map map) {
        System.out.println("业务逻辑类，实现了业务逻辑，依赖了数据访问"+studentMapper);
        List list= studentMapper.searchStudentByParams(new HashMap<String, String>());
        return list;
    }

    @Override
       public Page<StudentVo> findPage(int page, int rowCount) {
        PageRequest pageRequest=new PageRequest(page,rowCount);
        Page<StudentVo> studentVo=studentMapper.searchStudentByParams(null,pageRequest);
        return studentVo;
    }

    @Override
    public int insert(Student student) {
        try{
            studentMapper.insertStudent(student);
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer studentNo) {
        try{
            studentMapper.deleteStudentByStudentNo(studentNo);
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(Student student) {
        try{
            studentMapper.updateStudent(student);
            return 1;
        }catch (Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }

    @Override
    public Student finnById(Integer studentNo) {
        try {
           Student student= studentMapper.findById(studentNo);
            return student;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public StudentVo findById(Integer studentNo) {
        Map map=new HashMap();
        map.put("studentNo",studentNo);
        List<StudentVo> list=studentMapper.searchStudentByParams(map);
        if(list.size()!=0){
            return list.get(0);
        }else {
            return null;
        }
    }

}
