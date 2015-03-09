package com.thefragen.xbatterytweaks;

import com.fourmob.colorpicker.ColorPickerDialog;
import com.fourmob.colorpicker.ColorPickerSwatch.OnColorSelectedListener;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class PreferenceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preference, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_preference,
					container, false);
			return rootView;
		}
		
	/*	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);

			
			final ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
			colorPickerDialog.initialize(R.string.colorTitle, new int[] { Color.CYAN, Color.LTGRAY, Color.BLACK, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED, Color.GRAY, Color.YELLOW }, Color.YELLOW, 3, 2);
			colorPickerDialog.setOnColorSelectedListener(new OnColorSelectedListener() {
				public void onColorSelected(int color) {
					Toast.makeText(getActivity(), "Color : " + color, Toast.LENGTH_SHORT).show();
				}
			});

			getView().findViewById(R.id.colorButton).setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					Toast.makeText(getActivity(), "Button pressed", Toast.LENGTH_SHORT).show();
			//		colorPickerDialog.show(Preference.getFragmentManager, "colorpicker");
				}
			});
			
		}*/
	}
}
