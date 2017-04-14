package com.hougr.leakcanary;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import hougr.com.hougrleakcanary.BuildConfig;

public class ExampleApplication extends Application {
    private static final String TAG = "内存泄漏APP";
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        ExampleApplication application = (ExampleApplication) context.getApplicationContext();
        return application.mRefWatcher;
    }

    /**
     * 初始化LeakCanary工具
     * 如果开发需要在debug编译模式下启用，请修改if判断语句和build.gradle中的依赖选项
     */
    private void initLeakCanary(Application mContext) {
        if ("nodebug".equals(BuildConfig.BUILD_TYPE)) {
            Log.d(TAG, BuildConfig.BUILD_TYPE + "Compile, LeakCanary is enabled");
            LeakCanary.install(mContext);
        } else {
            Log.d(TAG, BuildConfig.BUILD_TYPE + ", disable LeakCanary and BlockCanary");
        }
    }
}
