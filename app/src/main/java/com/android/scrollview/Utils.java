package com.android.scrollview;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by baina on 18-3-30.
 */

public class Utils {

    /**
     * Get the screen width
     *
     * @param context
     * @return
     * @author mapeng_thun
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    /**
     * Get the screen height
     *
     * @param context
     * @return
     * @author mapeng_thun
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        return height;
    }
}
