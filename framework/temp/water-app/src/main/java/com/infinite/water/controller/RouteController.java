package com.infinite.water.controller;

import com.infinite.water.core.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hx on 16-7-29.
 */
@Controller
public class RouteController extends AbstractController {
    private static Logger log = LoggerFactory.getLogger(RouteController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
//        mav.setView(new RedirectView("http://localhost:63342/app-web/src/login.html", false));
//        return "login.jsp";
        mav.setViewName("login.jsp");
        return mav;
    }

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public ModelAndView app() {
//        model.addAttribute("username", "admin");
        ModelAndView mav = new ModelAndView();
        mav.addObject("username", "admin");
//        mav.setView(new RedirectView("http://localhost:63342/app-web/src/index.html", false));
        mav.setViewName("index.jsp");
//        return "index.jsp";
        return mav;
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
