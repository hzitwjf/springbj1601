package com.hzit.controller;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Student;
import com.hzit.dao.vo.StudentVo;
import com.hzit.servcies.GradeServices;
import com.hzit.servcies.StudentServcies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentServcies studentServcies;
    @Autowired
    private GradeServices gradeServices;
    @RequestMapping("/findall")
    @ResponseBody
    public List<StudentVo> findAll(){
        List<StudentVo> list=studentServcies.findAll(null);
        return list;
    }
    @RequestMapping("/find")
    public String find(@RequestParam(name="page",defaultValue ="0")Integer page,ModelMap modelMap){
        if(page<=0){
            page=0;
        }
        Page<StudentVo> list=studentServcies.findPage(page,4);
        modelMap.put("list",list);
        modelMap.put("courpage",page);
        return "studentinfo";
    }
    @RequestMapping("/add")
    @ResponseBody
    public int insert(Student student,ModelMap modelMap){
        int i=studentServcies.insert(student);
        return i;
    }
    @RequestMapping("/insert")
    public String add(ModelMap modelMap){
       List<Grade> grade= gradeServices.findAll();
        modelMap.put("grade",grade);
        return "addstudent";
    }
    @RequestMapping("/editstudent")
    @ResponseBody
    public int xiugai(Student student){
        int i=studentServcies.update(student);
        return i;
    }
    @RequestMapping("/toupdate")
    public String update(@RequestParam("studentNo")Integer studentNo,ModelMap modelMap){
            Student student=studentServcies.finnById(studentNo);
            List<Grade> grade= gradeServices.findAll();
            modelMap.put("grade",grade);
            modelMap.put("student",student);
            return "updatestudent";
    }
    @RequestMapping("/delete")
    @ResponseBody
    public int delete(@RequestParam(name="stuNo")Integer stuNo) {
       int i= studentServcies.delete(stuNo);
        return i;
    }
}
