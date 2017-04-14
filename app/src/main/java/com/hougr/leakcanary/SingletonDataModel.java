package com.hougr.leakcanary;

import android.content.Context;

public class SingletonDataModel {

    private static SingletonDataModel sInstance;
    private String mInfo = "我在测试单例内存泄漏";
//    private TextView mRetainedTextView;
    private static Context mContext;

    private SingletonDataModel(Context context){
        mContext = context;
    }


    public static SingletonDataModel getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SingletonDataModel(context);
        }
        return sInstance;
    }

//    public void setRetainedTextView(TextView textView) {
//        mRetainedTextView = textView;
//    }


    public String getmInfo() {
        return mInfo;
    }
}