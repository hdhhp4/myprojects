package com.dhhe.demo.controller;

import com.dhhe.demo.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhhe.demo.service.UserService;
import com.dhhe.demo.util.JsonResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户模块控制器
 *
 * @author hedon
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping("/regist")
//    public JsonResponse<Void> doRegist(User user) {
//        return JsonResponse.getInstance();
//    }
//
//    @RequestMapping("/login")
//    public JsonResponse<User> login(User user, HttpServletRequest request) throws MyException {
//        User result = userService.findByUserNameAndPassword(user);
//        if (result == null) {
//            throw new MyException("用户名或密码不正确", MyException.ExCode.loginErr.getCode());
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("user", result);
//        return JsonResponse.success(result, null);
//    }
//
//    @RequestMapping("/findById")
//    public JsonResponse<User> findById(String id) {
//        User user = userService.findById(id);
//        return JsonResponse.success(user, null);
//    }

}
