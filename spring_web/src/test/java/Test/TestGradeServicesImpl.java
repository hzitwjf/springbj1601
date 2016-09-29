package Test;

import com.hzit.StartSpring;
import com.hzit.dao.entity.Grade;
import com.hzit.servcies.GradeServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(StartSpring.class)
public class TestGradeServicesImpl {
    @Autowired
    private GradeServices gradeServices;
    @Test
    public void findAll(){
        List<Grade> list=gradeServices.findAll();
        for(Grade g : list){
            System.out.print(g.getGradeId()+"\t\t");
            System.out.println(g.getGradeName());
        }
    }
}
