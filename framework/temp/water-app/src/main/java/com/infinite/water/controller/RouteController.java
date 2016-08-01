package com.infinite.water.controller;

import com.infinite.water.core.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hx on 16-7-29.
 */
@Controller
public class RouteController extends AbstractController {
    private static Logger log = LoggerFactory.getLogger(RouteController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login.jsp";
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String app() {
        return "index.jsp";
    }

    @RequestMapping(value = "/tpl/**", method = RequestMethod.GET)
    public String template(HttpServletRequest request) {
        String path = request.getServletPath();
        if (path.startsWith("/")) {
            return path.substring(1);
        }
        return path;
    }

}
