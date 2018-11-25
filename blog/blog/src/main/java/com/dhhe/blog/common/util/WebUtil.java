package com.dhhe.blog.common.util;

import com.dhhe.blog.persistent.dto.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 常用的web工具方法
 */
public class WebUtil {

    /**
     * 获取当前登录的用户信息
     *
     * @param request
     * @return
     */
    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = getSession(request);
        Object curUser = session.getAttribute("currentUser");
        if (curUser == null) {
            return null;
        }
        return (User) curUser;
    }

    /**
     * 清除用户信息
     *
     * @param request
     * @return
     */
    public static Boolean cleanUserInfo(HttpServletRequest request) {
        HttpSession session = getSession(request);
        return clearSession(session, "currentUser");
    }

    /**
     * 清除session字段
     *
     * @param session
     * @param attrName
     * @return
     */
    public static Boolean clearSession(HttpSession session, String attrName) {
        session.removeAttribute(attrName);
        return true;
    }

    /**
     * 获取会话对象
     *
     * @param request
     * @return
     */
    public static HttpSession getSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session;
    }

    /**
     * 设置属性
     *
     * @param session
     * @param attrName
     * @param value
     */
    public static void setAttribute(HttpSession session, String attrName, Object value) {
        session.setAttribute(attrName, value);
    }

    /**
     * 批量设置属性
     *
     * @param session
     * @param map
     */
    public static void setAttributes(HttpSession session, Map<String, Object> map) {
        for (String key : map.keySet()) {
            setAttribute(session, key, map.get(key));
        }
    }

    /**
     * 设置当前用户到会话
     * TODO session 的超时时间设置？
     *
     * @param request
     * @param user
     */
    public static void setCurrentUser(HttpServletRequest request, User user) {
        setAttribute(request.getSession(), "currentUser", user);
    }

}
