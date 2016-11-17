package com.ssau.lab1.ui;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;


import com.ssau.lab1.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_compat);
    }
}
