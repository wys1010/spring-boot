package com.wys.ctrl;

import com.wys.domain.UserEntity;
import com.wys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wys on 2016-10-26.
 */


@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findAll")
    List<UserEntity> findAll(){
        return userService.findAll();
    }


    @RequestMapping("findById/{id}")
    UserEntity findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @RequestMapping("save")
    void save(UserEntity entity){
        userService.add(entity);
    }

    @RequestMapping(value = "delete/{id}",method = RequestMethod.DELETE)
    void delete(@PathVariable Long id){
        userService.delete(id);
    }



}
