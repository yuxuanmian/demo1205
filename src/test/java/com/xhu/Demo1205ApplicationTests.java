package com.xhu;

import com.xhu.enity.Accont;
import com.xhu.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1205ApplicationTests {

    @Autowired
    IUserService service;

    @Test
    void contextLoads() {
        service.Login(new Accont("00001","yuxuanmian081101"));
    }

}
