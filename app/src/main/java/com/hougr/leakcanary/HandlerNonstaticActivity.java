package com.hougr.leakcanary;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import hougr.com.hougrleakcanary.R;

public class HandlerNonstaticActivity extends AppCompatActivity {
    private TextView mHandlerLeakText;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mHandlerLeakText.setText("现在显示的不是初始值了");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_nonstatic);
        mHandlerLeakText = (TextView) findViewById(R.id.handler_leak_text);
        loadData();
    }

    private void loadData(){
        //...request
        Message message = Message.obtain();
        mHandler.sendMessage(message);
        Log.d("发送消息","成功");

    }
}
