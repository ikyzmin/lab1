package com.ssau.lab1.ui.dialogs;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.DialogPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.ssau.lab1.R;


public class ColorPreference extends DialogPreference {

    int color;

    public ColorPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWidgetLayoutResource(R.layout.p_color);

    }


    @Override
    protected void onClick() {
    }


    public ColorPreference(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorPreference(Context context) {
        this(context,null);
    }

    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue) {
        if (restorePersistedValue){
            color=  getPersistedInt(Color.YELLOW);
        }else{
            color = (Integer) defaultValue;
        }
        persistInt(color);
        notifyChanged();
    }

    @Override
    protected Object onGetDefaultValue(TypedArray a, int index) {
        return Color.YELLOW;
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        AppCompatImageView imageView  = (AppCompatImageView) holder.findViewById(R.id.color_view);
        imageView.getDrawable().setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
    }
}
