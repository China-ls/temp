package com.infinite.framework.router.controller;

import com.infinite.framework.core.web.BasicRestController;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hx on 16-7-4.
 */
@RequestMapping("/test")
@RestController("TestController")
public class TestController extends BasicRestController {

    @RequestMapping("/roles")
    @ResponseBody
    public String roles() {
        logger.debug("login");
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setPassword("test".toCharArray());
        token.setUsername("test");
        login(token);
        return "response by : testShiroReuireRole";
    }

}
