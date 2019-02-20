package com.json.push;

/**
 * Created by Mr.Yang on 2019/2/20.
 */

public class Request {
    private boolean open;
    private String url;
    private String apkUrl;

    public Request(boolean open, String url, String apkUrl) {
        this.open = open;
        this.url = url;
        this.apkUrl = apkUrl;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }
}
