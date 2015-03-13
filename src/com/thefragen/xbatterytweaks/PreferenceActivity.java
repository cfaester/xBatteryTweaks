package com.thefragen.xbatterytweaks;


import com.fourmob.colorpicker.ColorPickerDialog;
import com.fourmob.colorpicker.ColorPickerSwatch.OnColorSelectedListener;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.preference.PreferenceFragment;
import android.widget.Toast;

public class PreferenceActivity extends FragmentActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Display the fragment as the main content.
		FragmentManager mFragmentManager = getSupportFragmentManager();
		FragmentTransaction mFragmentTransaction = mFragmentManager
				.beginTransaction();
		PrefsFragment mPrefsFragment = new PrefsFragment();
		mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
		mFragmentTransaction.commit();

	}

	public static class PrefsFragment extends PreferenceFragment {

		@SuppressWarnings("deprecation")
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			getPreferenceManager().setSharedPreferencesMode(MODE_WORLD_READABLE);
			
			// Load the preferences from an XML resource
			addPreferencesFromResource(R.xml.preferences);
			
			SharedPreferences mPrefs = getPreferenceScreen().getSharedPreferences();
			
			
			final ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
			colorPickerDialog.initialize(R.string.colorTitle, new int[] {Color.TRANSPARENT, Color.parseColor("#F44336"), Color.parseColor("#E91E63"),
					Color.parseColor("#9C27B0"),
					Color.parseColor("#673AB7"),
					Color.parseColor("#3F51B5"),
					Color.parseColor("#2196F3"),
					Color.parseColor("#03A9F4"),
					Color.parseColor("#00BCD4"),
					Color.parseColor("#009688"),
					Color.parseColor("#4CAF50"),
					Color.parseColor("#8BC34A"),
					Color.parseColor("#CDDC39"),
					Color.parseColor("#FFEB3B"),
					Color.parseColor("#FFC107"),
					Color.parseColor("#FF9800"),
					Color.parseColor("#FF5722"),
					Color.parseColor("#795548"),
					Color.parseColor("#9E9E9E"),
					Color.parseColor("#607D8B")}, mPrefs.getInt("colorBut", Color.parseColor("#FF5722")), 3, 2);
			
			final Preference colorButton = (Preference)findPreference("colorBut");
			colorButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference pref) { 
                    colorPickerDialog.show(getActivity().getSupportFragmentManager(), "colorPicker");
                    return true;
                }
            });
			
			colorPickerDialog.setOnColorSelectedListener(new OnColorSelectedListener() {
				SharedPreferences prefs = getPreferenceScreen().getSharedPreferences();

				@Override
				public void onColorSelected(int color) {
					if(prefs.edit().putInt("colorBut", color).commit()){
						Toast.makeText(getActivity(), "Color set. Please (soft) reboot phone. ", Toast.LENGTH_SHORT).show();
					};
					
				}
			});
		}
	}
}
 

