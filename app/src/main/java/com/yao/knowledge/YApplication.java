package com.yao.knowledge;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Created by yao on 2017/5/6.
 */

public class YApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    private void initLogger() {
        Logger
                .init("YAO")                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
//                .hideThreadInfo()               // default shown
//                .logLevel(LogLevel.NONE)        // default LogLevel.FULL
                .methodOffset(2);              // default 0
        //default AndroidLogAdapter
    }
}
