package com.android.scrollview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class OffsetActivity extends AppCompatActivity {

    private static final String TAG = OffsetActivity.class.getSimpleName();
    private float mLastX;
    private float mLastY;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offset);

        final TextView tv = findViewById(R.id.tv);
        tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mLastX = event.getRawX();
                        mLastY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float x = event.getRawX();
                        float y = event.getRawY();
                        float offsetX = x - mLastX;
                        float offsetY = y - mLastY;
                        tv.offsetLeftAndRight((int) offsetX);
                        tv.offsetTopAndBottom((int) offsetY);
                        mLastX = x;
                        mLastY = y;
                        Log.d(TAG, "tv位置:(" + tv.getX() + "," + tv.getY() + ")");
                        break;
                }
                return true;
            }
        });
    }
}
