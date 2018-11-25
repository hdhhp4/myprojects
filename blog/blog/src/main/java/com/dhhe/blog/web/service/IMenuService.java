package com.dhhe.blog.web.service;

import com.dhhe.blog.persistent.dto.Menu;

import java.util.List;

public interface IMenuService {

    List<Menu> findMenus(int type, int status);

}
