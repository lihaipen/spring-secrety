package com.lhp;

import com.lhp.dao.UserRepository;
import com.lhp.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SpringSecretyApplicationTests {
@Autowired
    UserRepository userRepository;
    @Test
    void contextLoads() {
    }

    @Test
    public void test89() {

        List<Admin> list = userRepository.findByUsername("lihaipeng");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode(list.get(0).getPassword().trim());
        list.get(0).setPassword(encodedPassword);

        userRepository.save(list.get(0));
    }
}
