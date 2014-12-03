package com.test.yop.Momentum;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Calendar;

/**
 * Momentum by Wout
 * Created by Yop Spanjers on 30-10-2014.
 */
public abstract class Clock {

    private static int[] colors = {
            Color.rgb(246, 230, 196),
            Color.rgb(200,237,253),
            Color.rgb(252,199,202),
            Color.rgb(179,233,216),
            Color.rgb(247,233,174),
            Color.rgb(211,211,246),
            Color.rgb(108,59,57),
            Color.rgb(75,132,138),
            Color.rgb(124,96,66),
            Color.rgb(247,173,89),
            Color.rgb(235,108,63),
            Color.rgb(208,75,52),
            Color.rgb(255,202,39),
            Color.rgb(147,37,166),
            Color.rgb(22,158,250),
            Color.rgb(118,7,47),
            Color.rgb(44,183,80),
            Color.rgb(100,22,151),
            Color.rgb(88,42,71),
            Color.rgb(27,40,121),
            Color.rgb(29,112,74),
            Color.rgb(252,216,82),
            Color.rgb(247,99,64),
            Color.rgb(232,57,52),
            Color.rgb(246,230,196)
    };

    static Paint innerCircle = new Paint();
    static Paint outerCircle = new Paint();

    public static void drawOuterCircle(Canvas canvas, int screenWidth, int screenHeight)
    {
        Calendar calendar = Calendar.getInstance();
        int x = screenWidth/2;
        int y = screenHeight/2;
        int intTime = calendar.get((Calendar.HOUR));
        outerCircle.setColor(colors[intTime]);
        canvas.drawCircle(x,y,400,outerCircle);
    }

    public static void drawInnerCircle(Canvas canvas, int screenWidth, int screenHeight)
    {
        Calendar calendar = Calendar.getInstance();
        float minute = calendar.get(Calendar.MINUTE);
        float second = calendar.get(Calendar.SECOND);
        int time = (int)(minute + (second/60));
        int width = ((400/60)*time);

        int x = screenWidth/2;
        int y = screenHeight/2;
        int intTime = calendar.get((Calendar.HOUR)) + 1;
        innerCircle.setColor(colors[intTime]);
        canvas.drawCircle(x,y,width,innerCircle);
    }
}
