package com.thefragen.xbatterytweaks;

import android.content.res.XResources;
import android.graphics.Color;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;

public class xBatteryTweaks implements IXposedHookZygoteInit{
	XSharedPreferences PreferenceActivity;
	
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		// TODO Auto-generated method stub
		PreferenceActivity = new XSharedPreferences(xBatteryTweaks.class.getPackage()
				.getName());
		PreferenceActivity.makeWorldReadable();
		XResources.setSystemWideReplacement("android", "color", "battery_saver_mode_color", Color.TRANSPARENT);

		
		
		
	}
	
	boolean enabled(String key, boolean defValue){
		return PreferenceActivity.getBoolean(key, defValue);
	}
}
