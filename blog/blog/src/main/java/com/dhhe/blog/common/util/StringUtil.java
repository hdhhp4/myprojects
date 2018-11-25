package com.dhhe.blog.common.util;

import org.springframework.util.StringUtils;

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 是否是空白字符串(包括长度为0)
     *
     * @param charSequence
     * @return
     */
    public static Boolean isBlankString(String charSequence) {
        char[] charArray = charSequence.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == ' ') {
                continue;
            }
            return false;
        }
        return true;
    }

    /**
     * 是否长度为0或为null
     *
     * @param charSequence
     * @return
     */
    public static Boolean isEmpty(String charSequence) {
        return charSequence == null || "".equals(charSequence);
    }

    /**
     * 是否为空
     *
     * @param charSequence
     * @return
     */
    public static Boolean isNull(String charSequence) {
        return charSequence == null;
    }

}
