package com.dhhe.blog.web.vo;

import com.dhhe.blog.persistent.dto.User;
import com.dhhe.blog.persistent.dto.UserInfo;

import java.util.List;

public class UserModel extends User {

    private List<UserInfo> userInfos;

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void setUserInfos(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }
}
