package com.lhp.service;

import com.lhp.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2019/11/17 12:04
 * @Created by
 */
@Service
public class UserServiceImpl {
    //通过使用@Modifying注解配合@Query注解完成UPDATE和DELETE,
    // 在JPQL中不支持INSERT
    //UPDATE和DELETE操作需要使用事务，
    // 所以我们在调用的service层中添加事务
    @Autowired
    UserRepository userRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = -1)
    //import javax.transaction.Transactional;
    public String updateUserName( Integer id) {
       return userRepository.updateUserName( id);


    }
}