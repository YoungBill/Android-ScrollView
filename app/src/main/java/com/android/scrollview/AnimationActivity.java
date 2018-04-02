package com.android.scrollview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by baina on 18-4-2.
 */

public class AnimationActivity extends AppCompatActivity {

    private static final String TAG = AnimationActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final TextView tv = findViewById(R.id.tv);
        tv.requestLayout();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(tv, "translationX", 0, 200).setDuration(1000).start();
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(tv, "translationY", 0, 200).setDuration(1000);
                animatorY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.d(TAG, "tv位置:[x: " + tv.getX() + ",y: " + tv.getY() + ",left: " + tv.getLeft() + ",top: " + tv.getTop() + "]");
                    }
                });
                animatorY.start();
            }
        });
    }
}
