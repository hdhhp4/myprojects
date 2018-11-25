package com.dhhe.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/index.html", "/"})
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/login.html")
    public String login() {
        return "common/login";
    }

    @RequestMapping("/regist.html")
    public String regist() {
        return "regist";
    }

    @RequestMapping("/admin/index.html")
    public String admin() {
        return "admin/index";
    }

}
