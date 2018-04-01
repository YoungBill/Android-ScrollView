package com.android.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ScrollerActivity extends AppCompatActivity {

    private static final String TAG = ScrollerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroller);

        findViewById(R.id.firstPageIb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScrollerActivity.this, "点击ImageButton", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
