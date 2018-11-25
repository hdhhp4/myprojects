package com.dhhe.blog.web.service;

import com.dhhe.blog.persistent.dto.User;
import com.dhhe.blog.persistent.dto.UserInfo;
import com.dhhe.blog.web.vo.UserModel;

import java.util.List;

public interface IUserService {

    User findById(String id);

    User findByUserNameAndPassword(User user);

    UserModel findByIdWithUserInfo(String id);

    List<UserInfo> findUserInfoByUserId(String userId);

    UserModel findByUserNameAndPasswordWithUserInfo(User user);

    List<UserModel> findList(User user);

    Boolean modifyUserInfo(List<UserInfo> userInfos);

    Boolean delete(String userId);

}
