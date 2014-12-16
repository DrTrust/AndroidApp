package com.test.Momentum.Momentum;

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
            Color.rgb(255, 206, 0),
            Color.rgb(0,0,0),
            Color.rgb(11,8,112),
            Color.rgb(244,221,146),
            Color.rgb(18,123,108),
            Color.rgb(114,0,0), //5
            Color.rgb(249,177,61),
            Color.rgb(121,170,211),
            Color.rgb(255,194,226),
            Color.rgb(87,255,183),
            Color.rgb(239,237,226), //10
            Color.rgb(255,243,133),
            Color.rgb(216,216,216),
            Color.rgb(243,229,69),
            Color.rgb(52,42,57),
            Color.rgb(237,61,0), //15
            Color.rgb(63,158,50),
            Color.rgb(0,76,40),
            Color.rgb(191,0,14),
            Color.rgb(0,49,86),
            Color.rgb(248,180,54), //20
            Color.rgb(6,6,140),
            Color.rgb(79,9,0),
            Color.rgb(255,109,90),
            Color.rgb(255, 206, 0)
    };

    static Paint innerCircle = new Paint();
    static Paint outerCircle = new Paint();

    public static void drawOuterCircle(Canvas canvas)
    {
        Calendar calendar = Calendar.getInstance();
        int x = canvas.getWidth()/2;
        int y = canvas.getHeight()/2;
        int intTime = calendar.get((Calendar.HOUR_OF_DAY));
        outerCircle.setColor(colors[intTime]);
        canvas.drawCircle(x,y,400,outerCircle);
    }

    public static void drawInnerCircle(Canvas canvas)
    {
        Calendar calendar = Calendar.getInstance();
        float minute = calendar.get(Calendar.MINUTE);
        float second = calendar.get(Calendar.SECOND);
        int time = (int)(minute + (second/60));
        int width = ((400/60)*time);

        int x = canvas.getWidth()/2;
        int y = canvas.getHeight()/2;
        int intTime = calendar.get((Calendar.HOUR_OF_DAY)) + 1;
        innerCircle.setColor(colors[intTime]);
        canvas.drawCircle(x,y,width,innerCircle);
    }

    public static void drawOuterCircle(Canvas canvas, int intTimeHours)
    {
        int x = canvas.getWidth()/2;
        int y = canvas.getHeight()/2;
        outerCircle.setColor(colors[intTimeHours]);
        canvas.drawCircle(x,y,400,outerCircle);
    }

    public static void drawInnerCircle(Canvas canvas, int intTimeHours, int intTimeMinutes)
    {
        Calendar calendar = Calendar.getInstance();
        float minute = intTimeMinutes;
        float second = 0;
        int time = (int)(minute + (second/60));
        int width = ((400/60)*time);
        int x = canvas.getWidth()/2;
        int y  = canvas.getHeight()/2;
        innerCircle.setColor(colors[intTimeHours+1]);
        canvas.drawCircle(x,y,width,innerCircle);
    }

    public static void drawOuterCircleSet(Canvas canvas, int screenWidth, int screenHeight, int hour)
    {
        Calendar calendar = Calendar.getInstance();
        int x = screenWidth/2;
        int y = screenHeight/2;
        outerCircle.setColor(colors[hour]);
        canvas.drawCircle(x,y,400,outerCircle);
    }
}
