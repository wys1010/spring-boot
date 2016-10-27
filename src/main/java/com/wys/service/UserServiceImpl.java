package com.wys.service;

import com.wys.domain.UserEntity;
import com.wys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wys on 2016-10-26.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public Long add(UserEntity userEntity) {
//        userRepository.save(new UserEntity("刘小艳",25,"刘","小艳",new Date()));
        UserEntity entity = userRepository.save(userEntity);
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void update(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
