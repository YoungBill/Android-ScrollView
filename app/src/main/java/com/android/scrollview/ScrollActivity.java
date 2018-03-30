package com.android.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ScrollActivity extends AppCompatActivity {

    private static final String TAG = ScrollActivity.class.getSimpleName();
    private float mLastX;
    private float mLastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        final TextView tv = findViewById(R.id.tv);
        final RelativeLayout mainView = findViewById(R.id.mainView);
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
                        float offsetX = mLastX - x;
                        float offsetY = mLastY - y;
                        // 先计算之前已经偏移了多少距离
                        int oldScrollX = mainView.getScrollX();
                        int oldScrollY = mainView.getScrollY();
                        // 本次需要偏移的距离=之前已经偏移的距离+本次手势滑动了多大距离
                        int scrollX = (int) (oldScrollX + offsetX);
                        int scrollY = (int) (oldScrollY + offsetY);
                        mainView.scrollTo(scrollX, scrollY);
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
