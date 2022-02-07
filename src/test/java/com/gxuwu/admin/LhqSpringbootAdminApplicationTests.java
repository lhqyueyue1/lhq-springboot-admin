package com.gxuwu.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LhqSpringbootAdminApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(UUID.randomUUID().toString());
    }

}
