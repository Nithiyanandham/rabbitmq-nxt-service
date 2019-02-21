package com.nxt.spboot.rabbitmqservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by nithi on 2019-02-21.
 *
 */
@RequestMapping("/")
@Controller
public class HomeController {

    @ApiIgnore
    @RequestMapping("/")
    public String index(ModelMap model) throws Exception {
        return "redirect:swagger-ui.html";
    }
}

