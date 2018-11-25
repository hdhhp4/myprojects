package com.dhhe.blog.web.controller;

import com.dhhe.blog.common.util.JsonResponse;
import com.dhhe.blog.common.util.WebUtil;
import com.dhhe.blog.persistent.dto.User;
import com.dhhe.blog.persistent.dto.UserInfo;
import com.dhhe.blog.web.service.IUserService;
import com.dhhe.blog.web.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户服务
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findByIdWithUserInfo")
    public JsonResponse<UserModel> findByIdWithUserInfo(String id) {
        UserModel userModel = userService.findByIdWithUserInfo(id);
        return JsonResponse.success(userModel, "");
    }

    @RequestMapping("/findById")
    public JsonResponse<User> findById(String id) {
        User user = userService.findById(id);
        return JsonResponse.success(user, "");
    }

    @RequestMapping("/login")
    public JsonResponse<Void> login(User user, HttpServletRequest request) {
        user.setStatus(0);
        user = userService.findByUserNameAndPassword(user);
        if (user == null) {
            return JsonResponse.fail("用户名或密码错误");
        }
        WebUtil.setCurrentUser(request, user);
        return JsonResponse.success("登录成功");
    }

    @RequestMapping("/findUserInfoByUserId")
    public JsonResponse<List<UserInfo>> findUserInfoByUserId(String userId) {
        List<UserInfo> userInfos = userService.findUserInfoByUserId(userId);
        return JsonResponse.success(userInfos, "");
    }

    @RequestMapping("/findByUserNameAndPasswordWithUserInfo")
    public JsonResponse<UserModel> findByUserNameAndPasswordWithUserInfo(User user) {
        UserModel userModel = userService.findByUserNameAndPasswordWithUserInfo(user);
        return JsonResponse.success(userModel, "");
    }

    @RequestMapping("/modifyUserInfo")
    public JsonResponse<Void> modifyUserInfo(UserModel userModel) {
        Boolean result = userService.modifyUserInfo(userModel.getUserInfos());
        if (result) {
            return JsonResponse.success("");
        } else {
            return JsonResponse.fail("");
        }
    }

    @RequestMapping("/delete")
    public JsonResponse<Void> delete(String userId) {
        Boolean result = userService.delete(userId);
        if (result) {
            return JsonResponse.success("");
        } else {
            return JsonResponse.fail("");
        }
    }

}
