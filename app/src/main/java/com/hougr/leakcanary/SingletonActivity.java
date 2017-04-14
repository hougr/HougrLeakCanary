package com.hougr.leakcanary;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import hougr.com.hougrleakcanary.R;


public class SingletonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = (TextView) findViewById(R.id.test_text_view);

//        SingletonDataModel.getInstance(SingletonActivity.this).setRetainedTextView(textView);
        textView.setText(SingletonDataModel.getInstance(SingletonActivity.this).getmInfo());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SingletonActivity.this.finish();
    }
}