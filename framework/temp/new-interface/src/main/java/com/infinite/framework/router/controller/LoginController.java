package com.infinite.framework.router.controller;

import com.infinite.framework.auth.authtoken.ApplicationAuthenticationToken;
import com.infinite.framework.core.web.entity.Response;
import com.infinite.framework.router.entity.LoginResponse;
import com.infinite.framework.router.entity.ResponseCode;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hx on 16-7-6.
 */
@RestController("LoginController")
public class LoginController extends RouterBasicRestController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response login(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password
    ) {
        Response response = null;
        try {
            login(new UsernamePasswordToken(username, password));
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUsername(username);
            loginResponse.setPassword(password);
            response = makeResponse(ResponseCode.SUCCESS, loginResponse);
        } catch (AuthenticationException e) {
            logger.warn("fail use [u:{},p:{}] to login", username, password, e);
            response = makeResponse(ResponseCode.AUTH_ACCOUNT_ERROR);
        }
        return response;
    }

    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public Response getToken(
            @ModelAttribute("appkey") String appkey
    ) {
        Response response = null;
        try {
            login(new ApplicationAuthenticationToken(appkey));
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setAppkey(appkey);
            response = makeResponse(ResponseCode.SUCCESS, loginResponse);
        } catch (AuthenticationException e) {
            logger.warn("fail use [appkey: {}] to login", appkey, e);
            response = makeResponse(ResponseCode.AUTH_ACCOUNT_ERROR);
        }
        return response;
    }


}
