package com.thefragen.xbatterytweaks;

import android.content.res.XResources;
import android.graphics.Color;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;

public class xBatteryTweaks implements IXposedHookZygoteInit{
	XSharedPreferences PreferenceActivity;
	public static final String GLOBAL_COLOR_BATTERY = "colorBut";
	
	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		// TODO Auto-generated method stub
		PreferenceActivity = new XSharedPreferences(xBatteryTweaks.class.getPackage().getName());
		
		PreferenceActivity.makeWorldReadable();
		
		
		XResources.setSystemWideReplacement("android", "color", "battery_saver_mode_color", enabled(GLOBAL_COLOR_BATTERY, Color.TRANSPARENT));
		XposedBridge.log("  [xBatteryTweaks (Remove Battery Saver Warning Color)] initialized");
		XposedBridge.log("XBT: Grabbed color: " + enabled(GLOBAL_COLOR_BATTERY, Color.TRANSPARENT));
        
	}

	int enabled(String key, int defValue){
		
		return PreferenceActivity.getInt(key, defValue);
	}
}
