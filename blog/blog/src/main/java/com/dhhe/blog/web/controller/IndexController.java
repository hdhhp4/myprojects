package com.dhhe.blog.web.controller;

import com.dhhe.blog.common.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        WebUtil.cleanUserInfo(request);
        response.sendRedirect("/index");
    }

    @RequestMapping("/admin/index")
    public String admin(){
        return "/admin/index";
    }
}
