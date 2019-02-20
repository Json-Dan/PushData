package com.json.push.bean;

/**
 * Created by Mr.Yang on 2019/2/20.
 */

public class FormBean {
    //平台
    private String marketName;
    //项目名字
    private String appName;

    public FormBean(String marketName, String appName) {
        this.marketName = marketName;
        this.appName = appName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
