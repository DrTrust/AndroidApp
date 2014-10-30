package com.example.yop.myapplication;

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

/**
 * Created by Jeroen on 2014-10-30.
 */
public class DrawFragment extends Fragment {
    private class DrawView extends View {
        Paint paint = new Paint();

        public DrawView(Context context) {
            super(context);
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
            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(1);
            canvas.drawCircle(300, 400, 200, paint);
            canvas.drawCircle(100, 100, 100, paint);
            canvas.drawCircle(400, 600, 150, paint);
            canvas.drawCircle(300, 800, 200, paint);
            canvas.drawCircle(500, 200, 80, paint);
            canvas.drawCircle(300, 300, 130, paint);
            paint.setColor(Color.RED);
            paint.setStrokeWidth(5);
            canvas.drawLine(0, 0, 500, 500, paint);
            canvas.drawLine(500, 0, 0, 500, paint);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
            this.setMeasuredDimension(parentWidth, parentHeight);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return new DrawView(this.getActivity());
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

