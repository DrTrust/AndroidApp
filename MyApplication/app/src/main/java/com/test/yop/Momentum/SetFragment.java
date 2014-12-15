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

import java.util.Calendar;

public class SetFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private static TimePicker timePicker;
    private static DrawFragment.DrawView drawView;

    public SetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set, container, false);
        DrawFragment drawFragment = (DrawFragment) getFragmentManager().findFragmentById(R.id.fragment);
        drawView = drawFragment.getDrawView();
        drawView.setTimeUpdate(false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timePicker = (android.widget.TimePicker) getView().findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        drawView.setTimePicker(timePicker);
    }
}
