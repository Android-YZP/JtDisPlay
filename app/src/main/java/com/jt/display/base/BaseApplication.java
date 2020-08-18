package com.jt.display.base;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by 姚中平 on 2018/1/11.
 */

public class BaseApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        //Logger的初始化
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // 显示线程信息
                .methodCount(1)         // 显示这一行的Log又几个方法的嵌套
                .methodOffset(0)        // 隐藏内部方法调用，以抵消。默认的5
                .tag("=======》")   // 每个日志的全局标记。默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        BaseApplication.context = getApplicationContext();

    }

    public static Context getAppContext() {
        return BaseApplication.context;
    }

}
