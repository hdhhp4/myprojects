package com.dhhe.demo.util;

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

	@Value("${system.name}")
	public void setSystemName(String systemName) {
		Config.systemName = systemName;
	}

	@Value("${system.author}")
	public void setAuthor(String author) {
		Config.author = author;
	}

	@Value("${system.version}")
	public void setVersion(String version) {
		Config.version = version;
	}

}
