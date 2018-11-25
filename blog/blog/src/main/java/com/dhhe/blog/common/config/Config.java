package com.dhhe.blog.common.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 配置读取
 * @author dhhe
 *
 */
@Component
public class Config {

    public static String systemName;

    public static String author;

    public static String version;

    public static String loginPage;

    public static String[] exclusions;

    @Value("${application.system.name}")
    public void setSystemName(String systemName) {
        Config.systemName = systemName;
    }

    @Value("${application.system.author}")
    public void setAuthor(String author) {
        Config.author = author;
    }

    @Value("${application.system.version}")
    public void setVersion(String version) {
        Config.version = version;
    }

    @Value("${application.login-page}")
    public void setLoginPage(String loginPage) {
        Config.loginPage = loginPage;
    }

    @Value("${application.interceptor.exclusions}")
    public void setExcludeUrls(String exclusions) {
        Config.exclusions = exclusions.split(",");
    }

}
