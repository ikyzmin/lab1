package com.ssau.lab1.ui.menu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;

import com.ssau.lab1.R;
import com.ssau.lab1.ui.SettingsActivity;

public enum MenuItem {
    HEADER(-1, null),
    BIO(R.string.menu_bio, null),
    TAGS(R.string.menu_tags, null),
    SETTINGS(R.string.menu_settings, SettingsActivity.class);

    @StringRes
    int titleId;

    Class<? extends AppCompatActivity> activity;

    MenuItem(@StringRes int titleId, Class<? extends AppCompatActivity> activity) {
        this.titleId = titleId;
        this.activity = activity;
    }

    public int getTitleId() {
        return titleId;
    }

    public void activate(Context context) {
        context.startActivity(new Intent(context, activity));
    }
}
