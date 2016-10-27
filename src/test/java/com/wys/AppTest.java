package com.wys;

import com.wys.domain.UserEntity;
import com.wys.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Server.class)
@SpringApplicationConfiguration(classes = Server.class)
public class AppTest {

    @Autowired
    UserService userService;

    @Autowired
    CacheManager  cacheManager;

//    @Before
//    public void before(){
//        userService.add(new UserEntity("刘小艳",25,"刘","小艳",new Date()));
//    }

    @Test
    public void test() throws Exception {
        Long id = userService.add(new UserEntity("刘小艳", 25, "刘", "小艳", new Date()));

        UserEntity u1 = userService.findById(id);
        System.out.println("第一次查询：" + u1.getAge());

        UserEntity u2 = userService.findById(id);
        System.out.println("第二次查询：" + u2.getAge());

//        userService.delete(id);

        u2.setAge(100);
        userService.update(u2);

        UserEntity u3 = userService.findById(id);
        System.out.println("第三次查询：" + u3.getAge());
    }

}
