package com.lhp.util;

import com.lhp.dao.UserRepository;
import com.lhp.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Classname CustomUserDetailsService
 * @Description TODO
 * @Date 2019/11/17 16:08
 * @Created by
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 查询用户
        List<Admin> list = userRepository.findByUsername(username);
        if (list == null) {
            //log.warn("User: {} not found", login);
            throw new UsernameNotFoundException("User " + list + " was not found in db");
            //这里找不到必须抛异常
        }
        // 2. 设置角色
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(list.get(0).getRole());
        grantedAuthorities.add(grantedAuthority);
System.out.println(list.get(0).getRole());
        return new org.springframework.security.core.userdetails.User(username,
                list.get(0).getPassword(),true,true,true,true, grantedAuthorities);
    }
}