package com.TheFragen.xBatteryTweaks;

import android.R.color;
import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookZygoteInit;

public class xBatteryTweaks implements IXposedHookZygoteInit{

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		// TODO Auto-generated method stub
		 XResources.setSystemWideReplacement("android", "color", "battery_saver_mode_color", color.transparent);
	}
	
}
