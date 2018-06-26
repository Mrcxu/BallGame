package com.wzbc.ballgame;

/**
 * Created by Iloved on 2018/6/6.
 */

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;


public class Globals {
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;

    public static void init(Activity a) {
        Display display = a.getWindowManager().getDefaultDisplay();
        Point outSize = new Point();
        display.getSize(outSize);
        SCREEN_WIDTH = outSize.x;
        SCREEN_HEIGHT = outSize.y;
    }

}