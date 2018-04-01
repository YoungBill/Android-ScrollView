package com.android.scrollview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.offsetBt).setOnClickListener(this);
        findViewById(R.id.scrollBt).setOnClickListener(this);
        findViewById(R.id.scrollerBt).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.offsetBt:
                startActivity(new Intent(MainActivity.this, OffsetActivity.class));
                break;
            case R.id.scrollBt:
                startActivity(new Intent(MainActivity.this, ScrollActivity.class));
                break;
            case R.id.scrollerBt:
                startActivity(new Intent(MainActivity.this, ScrollerActivity.class));
                break;
        }
    }
}
