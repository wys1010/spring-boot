package com.wys.repository;

import com.wys.domain.UserEntity;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wys on 2016-10-26.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
