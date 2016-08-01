package com.infinite.framework.router.controller;

import com.infinite.framework.auth.authtoken.ApplicationAuthenticationToken;
import com.infinite.framework.core.web.entity.Response;
import com.infinite.framework.router.entity.LoginResponse;
import com.infinite.framework.router.entity.ResponseCode;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hx on 16-7-6.
 * @since 1.0
 */
@RestController("LoginController")
public class LoginController extends RouterBasicRestController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response login(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password
    ) {
        Response response = null;
        try {
            if (StringUtils.isEmpty(username)) {
                response = makeResponse(ResponseCode.AUTH_ACCOUNT_USERNAME_EMPTY);
            } else if (StringUtils.isEmpty(password)) {
                response = makeResponse(ResponseCode.AUTH_ACCOUNT_PASSORD_EMPTY);
            } else {
                login(new UsernamePasswordToken(username, password));
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setUsername(username);
                loginResponse.setPassword(password);
                response = makeResponse(ResponseCode.SUCCESS, loginResponse);
            }
        } catch (ExcessiveAttemptsException e) {
            logger.warn("Excessive Attempts fail use [u:{},p:{}] to login", username, password);
            response = makeResponse(ResponseCode.AUTH_ACCOUNT_RETRY_LIMIT);
        } catch (UnknownAccountException e) {
            logger.warn("Unknown Account fail use [u:{},p:{}] to login", username, password);
            response = makeResponse(ResponseCode.AUTH_ACCOUNT_ERROR);
        } catch (IncorrectCredentialsException e) {
            logger.warn("Incorrect Credentials fail use [u:{},p:{}] to login", username, password);
            response = makeResponse(ResponseCode.AUTH_ACCOUNT_ERROR);
        } catch (AuthenticationException e) {
            logger.debug("e : {}", e.getClass().getName());
            logger.warn("Authentication fail use [u:{},p:{}] to login", username, password);
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