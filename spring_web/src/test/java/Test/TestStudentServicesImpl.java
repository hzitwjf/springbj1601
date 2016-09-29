package Test;

import com.fc.platform.commons.page.Page;
import com.hzit.StartSpring;
import com.hzit.dao.entity.Grade;
import com.hzit.dao.entity.Student;
import com.hzit.dao.vo.StudentVo;
import com.hzit.servcies.StudentServcies;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(StartSpring.class)
public class TestStudentServicesImpl {
    @Autowired
    private StudentServcies studentServcies;
    @Test
    public void findAll(){
        List<StudentVo> list=studentServcies.findAll(null);
        for (StudentVo s : list){
            System.out.println(s.getStudentName());
        }
    }
    @Test
    public void findPage(){
        Page<StudentVo> p=studentServcies.findPage(0,3);
        List<StudentVo> list=p.getContent();
        for (StudentVo s : list){
            System.out.println(s.getStudentName());
        }
        System.out.println("总行数"+p.getTotalElements());
        System.out.println("总页数"+p.getTotalPages());
    }
    @Test
    public void add(){
        Student student=new Student();
        student.setStudentName("张三");
        student.setLoginPwd("123");
        student.setAddress("警察局");
        int i=studentServcies.insert(student);
        System.out.println(i);
    }
    @Test
    public void update(){
        Student student=new Student();
        student.setStudentNo(673);
        student.setStudentName("张三");
        student.setLoginPwd("123");
        student.setAddress("警察局");
        int i=studentServcies.update(student);
        System.out.println(i);
    }
    @Test
    public void delete(){
        int i=studentServcies.delete(20);
        System.out.println(i);
    }
    @Test
    public void findById(){
      StudentVo studentVo=studentServcies.findById(6);

        System.out.println(studentVo.getGradeName());

        //System.out.println(list);
}
}
