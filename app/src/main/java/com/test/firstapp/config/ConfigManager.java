package com.test.firstapp.config;

import com.test.firstapp.BuildConfig;

/**
 * 域名配置,在application中初始化
 */
public class ConfigManager {
    private static volatile ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) {
            synchronized (ConfigManager.class) {
                if (instance == null) {
                    instance = new ConfigManager();
                }
            }
        }
        return instance;
    }

    public String getHost() {
        return BuildConfig.DOMAIN_NAME;
    }

    public String getHost2() {
        return BuildConfig.DOMAIN_NAME2;
    }
}
