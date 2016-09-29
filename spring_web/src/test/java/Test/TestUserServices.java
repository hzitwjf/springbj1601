package Test;


import com.hzit.StartSpring;
import com.hzit.servcies.UserServcies;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016/9/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(StartSpring.class)

public class TestUserServices {
    @Autowired
    private UserServcies userServcies;
    public void ceshi(){
      String s=  userServcies.findAll("哈哈哈哈");
        System.out.println(s);
    }
}
