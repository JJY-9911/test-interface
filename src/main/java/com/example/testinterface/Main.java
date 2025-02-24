package com.example.testinterface;

import com.example.testinterface.client.ApiClient;
import com.example.testinterface.model.User;

public class Main {
    public static void main(String[] args) {

        String accessKey = "jjyaccessKey";
        String secretKey = "abcdefg";
        String name = "testuser";

        ApiClient apiClient = new ApiClient(accessKey, secretKey);
        String str1 = apiClient.getNameByGet(name);
        String str2 = apiClient.getNameByPost(name);

        User user = new User();
        user.setName(name);
        String str3 = apiClient.getUserNameByPost(user);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }
}
