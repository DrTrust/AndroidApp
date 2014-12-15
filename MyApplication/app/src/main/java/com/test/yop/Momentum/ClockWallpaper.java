package com.test.yop.Momentum;
import android.graphics.Canvas;

/**
 * Created by Yop Spanjers on 3-12-2014.
 */
public class ClockWallpaper {
    public ClockWallpaper()
    {
    }

    public void     update(int elapsed_ms)
    {

    }

    public void     draw(Canvas canvas)
    {
        if (canvas == null)
            return;
        Clock.drawOuterCircle(canvas);
        Clock.drawInnerCircle(canvas);
    }
}
