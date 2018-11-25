package com.dhhe.blog.web.service.impl;

import com.dhhe.blog.persistent.dao.UserInfoMapper;
import com.dhhe.blog.persistent.dao.UserMapper;
import com.dhhe.blog.persistent.dto.User;
import com.dhhe.blog.persistent.dto.UserExample;
import com.dhhe.blog.persistent.dto.UserInfo;
import com.dhhe.blog.persistent.dto.UserInfoExample;
import com.dhhe.blog.web.service.IUserService;
import com.dhhe.blog.web.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User findById(String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public User findByUserNameAndPassword(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> result = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public UserModel findByIdWithUserInfo(String id) {
        User user = new User();
        user.setId(id);
        List<UserModel> result = userMapper.selectByRecord(user);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<UserInfo> findUserInfoByUserId(String userId) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return userInfos;
    }

    @Override
    public UserModel findByUserNameAndPasswordWithUserInfo(User user) {
        List<UserModel> result = userMapper.selectByRecord(user);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result.get(0);
    }

    @Override
    public List<UserModel> findList(User user) {
        List<UserModel> result = userMapper.selectByRecord(user);
        if (CollectionUtils.isEmpty(result)) {
            return null;
        }
        return result;
    }

    @Override
    @Transactional
    public Boolean modifyUserInfo(List<UserInfo> userInfos) {
        for (UserInfo userInfo : userInfos) {
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
        }
        return true;
    }

    @Override
    @Transactional
    public Boolean delete(String userId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andIdEqualTo(userId);
        User user = new User();
        user.setStatus(1);
        userMapper.updateByExampleSelective(user, userExample);

        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria userInfoCriteria = userInfoExample.createCriteria();
        userInfoCriteria.andUserIdEqualTo(userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(1);
        userInfoMapper.updateByExampleSelective(userInfo, userInfoExample);

        return true;
    }

}
