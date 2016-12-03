package com.ssau.lab1.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;


import com.ssau.lab1.R;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_compat);
        Preference preference = findPreference("sound");
        if (preference instanceof EditTextPreference){
            EditTextPreference editTextPreference =  (EditTextPreference)preference;
            if (editTextPreference.getText()!=null && editTextPreference.getText().trim().length() > 0){
                editTextPreference.setSummary(editTextPreference.getText());
            }else{
                editTextPreference.setSummary(getContext().getString(R.string.settings_sound_summary));
            }
        }
    }



    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = findPreference(key);
        if (preference instanceof EditTextPreference){
            EditTextPreference editTextPreference =  (EditTextPreference)preference;
            if (editTextPreference.getText().trim().length() > 0){
                editTextPreference.setSummary(editTextPreference.getText());
            }else{
                editTextPreference.setSummary(getContext().getString(R.string.settings_sound_summary));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }
}
