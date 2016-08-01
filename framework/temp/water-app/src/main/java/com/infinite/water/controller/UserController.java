package com.infinite.water.controller;

import com.infinite.water.core.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hx on 16-7-29.
 */
@Controller
public class UserController extends AbstractController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "redirect:/app";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String

}
