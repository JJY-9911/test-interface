package com.example.testinterface.controller;

import com.example.testinterface.model.User;
import com.example.testinterface.utils.SignUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("name")
public class NameController {

    @GetMapping("/1")
    public String getNameByGet(String name) {
        return "get name: " + name;
    }

    @PostMapping("/2")
    public String getNameByPost(@RequestParam String name) {
        return "post name: " + name;
    }

    @PostMapping("/3")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest rq) {

        String accessKey = rq.getHeader("accessKey");
//        String secretKey = rq.getHeader("secretKey");
        String nonce = rq.getHeader("nonce");
        String body = rq.getHeader("body");
        String timestamp = rq.getHeader("timestamp");
        String sign = rq.getHeader("sign");

        if(Long.parseLong(nonce) > 10000) {
            throw  new RuntimeException("无权限");
        }

        long now = System.currentTimeMillis() / 1000;

        if((now - Long.parseLong(timestamp)) > 300L) { //请求五分钟有效
            throw  new RuntimeException("无权限");
        }

        if(!accessKey.equals("jjyaccessKey")) {
            throw  new RuntimeException("无权限");
        }

        String serverSign = SignUtils.genSign(body, "abcdefg");
        if(!sign.equals(serverSign)) {
            throw  new RuntimeException("无权限");
        }
        return "post name: " + user.getName();
    }
}
