package com.lhp.dao;

import com.lhp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname UserReposity
 * @Description TODO
 * @Date 2019/11/17 11:50
 * @Created by
 */
@Repository
public interface UserRepository extends JpaRepository<Admin, Integer> {
    @Query(value = "select username  from Admin a where a.id=?1")
    String updateUserName(Integer id);

    List<Admin> findByUsername(String username);

}
