package com.thefragen.xbatterytweaks;

import android.content.res.XResources;
import android.graphics.Color;
import de.robv.android.xposed.IXposedHookZygoteInit;

public class xBatteryTweaks implements IXposedHookZygoteInit{

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
		// TODO Auto-generated method stub
		 XResources.setSystemWideReplacement("android", "color", "battery_saver_mode_color", Color.TRANSPARENT);	 
	}
}
