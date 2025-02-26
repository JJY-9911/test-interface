package com.example.testinterface;

import com.example.japisdk.client.ApiClient;
import com.example.japisdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class TestInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() {
        User user = new User();
        user.setName("test user");
        String str = apiClient.getUserNameByPost(user);
        System.out.println(str);
    }

}
