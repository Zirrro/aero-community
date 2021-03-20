package com.salieri.community;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class CommunityApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.currentTimeMillis());
        System.out.println(UUID.randomUUID());
    }

}
