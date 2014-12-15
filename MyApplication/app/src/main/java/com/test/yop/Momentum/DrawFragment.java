package com.test.yop.Momentum;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

/**
 * Momentum by Wout
 * Created by Yop Spanjers on 2014-10-30.
 */
public class DrawFragment extends Fragment {
    public class DrawView extends View {
        Paint paint = new Paint();
        boolean timeUpdate = true;
        TimePicker timePicker;

        public void setTimePicker(TimePicker timePicker) {
            this.timePicker = timePicker;
        }

        public void setTimeUpdate(boolean timeUpdate) {
            this.timeUpdate = timeUpdate;
        }

        public DrawView(Context context) {
            super(context);
            paint.setColor(Color.BLACK);
        }

        public DrawView(Context context, boolean timeUpdate) {
            super(context);
            this.timeUpdate = timeUpdate;
            paint.setColor(Color.BLACK);
        }

        public DrawView(Context context, AttributeSet attrs) {
            super(context, attrs);
            paint.setColor(Color.BLACK);
        }

        public DrawView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            paint.setColor(Color.BLACK);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (timeUpdate) {
                Clock.drawOuterCircle(canvas);
                Clock.drawInnerCircle(canvas);
            } else {
                Clock.drawOuterCircle(canvas, timePicker.getCurrentHour());
                Clock.drawInnerCircle(canvas, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
            }
            this.invalidate();
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
            this.setMeasuredDimension(parentWidth, parentHeight);
        }
    }

    private static DrawView drawView;
    private static boolean timeUpdate = true;

    public static void setTimeUpdate(boolean timeUpdate) {
        DrawFragment.timeUpdate = timeUpdate;
    }

    public static DrawView getDrawView() {
        return drawView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        drawView = new DrawView(this.getActivity(), timeUpdate);
        return drawView;
    }

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DrawFragment newInstance(int sectionNumber) {
        DrawFragment fragment = new DrawFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DrawFragment newInstance(int sectionNumber, boolean timeUpdate) {
        DrawFragment.timeUpdate = timeUpdate;
        DrawFragment fragment = new DrawFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public DrawFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
