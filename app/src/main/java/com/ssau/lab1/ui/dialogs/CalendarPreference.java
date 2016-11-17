package com.ssau.lab1.ui.dialogs;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.DatePicker;

import com.ssau.lab1.R;

import java.util.Calendar;


public class CalendarPreference extends DialogPreference implements DatePickerDialog.OnDateSetListener {

    String date;
    AppCompatTextView appCompatTextView;

    public CalendarPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWidgetLayoutResource(R.layout.p_calendar);
        init();
    }

    private void init() {
        date = getPersistedString(getContext().getString(R.string.date_format, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
        persistString(date);
    }


    @Override
    protected void onClick() {
        String[] date = this.date.split("\\.");
        int day = Integer.valueOf(date[0]);
        int month = Integer.valueOf(date[1]);
        int year = Integer.valueOf(date[2]);
        new DatePickerDialog(getContext(), this, year, month, day).show();
    }

    public CalendarPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarPreference(Context context) {
        this(context, null);
    }


    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        if (restorePersistedValue) {
            date = getPersistedString(getContext().getString(R.string.date_format, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR)));
        } else {
            date = (String) defaultValue;
        }
        persistString(date);
        notifyChanged();
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return getContext().getString(R.string.date_format, Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.YEAR));
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        appCompatTextView = (AppCompatTextView) holder.findViewById(R.id.date);
        appCompatTextView.setText(date);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = getContext().getString(R.string.date_format, dayOfMonth, month, year);
        appCompatTextView.setText(date);
        persistString(date);
        this.date = date;
    }
}
