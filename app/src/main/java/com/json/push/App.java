package com.json.push;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by Mr.Yang on 2019/2/20.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initAVOS();
    }

    private void initAVOS() {

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, Constant.appId, Constant.appKey);
        AVOSCloud.setDebugLogEnabled(true);
    }
}
