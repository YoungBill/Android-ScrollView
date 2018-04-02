package com.android.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baina on 18-4-2.
 */

public class LayoutParamsActivity extends AppCompatActivity {

    private static final String TAG = LayoutParamsActivity.class.getSimpleName();
    private float mLastX;
    private float mLastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutparams);

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
                        // 本次手势滑动了多大距离
                        float offsetX = x - mLastX;
                        float offsetY = y - mLastY;
                        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tv.getLayoutParams();
                        layoutParams.leftMargin += offsetX;
                        layoutParams.topMargin += offsetY;
                        tv.requestLayout();
                        mLastX = x;
                        mLastY = y;
                        Log.d(TAG, "tv位置:[x: " + tv.getX() + ",y: " + tv.getY() + ",left: " + tv.getLeft() + ",top: " + tv.getTop() + "]");
                        break;
                }
                return true;
            }
        });
    }
}
