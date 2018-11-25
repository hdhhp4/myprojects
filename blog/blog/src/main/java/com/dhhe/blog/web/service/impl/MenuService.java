package com.dhhe.blog.web.service.impl;

import com.dhhe.blog.persistent.dao.MenuMapper;
import com.dhhe.blog.persistent.dto.Menu;
import com.dhhe.blog.persistent.dto.MenuExample;
import com.dhhe.blog.web.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenus(int type, int status) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(type);
        criteria.andStatusEqualTo(status);
        List<Menu> menus = menuMapper.selectByExample(example);
        return menus;
    }
}
