package com.wys.service;

import com.wys.domain.UserEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by wys on 2016-10-26.
 */
@CacheConfig(cacheNames = "users")
public interface UserService {
    List<UserEntity> findAll();


    @Cacheable(key = "#p0")
    UserEntity findById(Long id);

    @CachePut(key = "#p0")
    Long add(UserEntity userEntity);

    @CacheEvict(key = "#p0")
    void delete(Long id);

    @CachePut(key = "#p0.id")
    void update(UserEntity userEntity);
}
