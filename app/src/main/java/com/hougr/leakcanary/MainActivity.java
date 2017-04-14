package com.hougr.leakcanary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import hougr.com.hougrleakcanary.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_go_to_singleton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goToSingleton();
//                goToHandlerLeank();
                goToAsyncTaskLeank();
            }
        });
    }

    private void goToSingleton() {
        Intent intent = new Intent(this, SingletonActivity.class);
        startActivity(intent);
    }

    private void goToHandlerLeank() {
        Intent intent = new Intent(this, HandlerNonstaticActivity.class);
        startActivity(intent);
    }

    private void goToAsyncTaskLeank() {
        Intent intent = new Intent(this, AsyncTaskLeakActivity.class);
        startActivity(intent);
    }

}
