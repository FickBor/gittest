package com.example.outuserentry;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	public static List<Activity> activities= new  ArrayList<Activity>();
	private  static Activity  activityy;
	public static void addavtivity(Activity activity)
	{
		activities.add(activity);
	}
	public static void removeactivity(Activity activity)
	{
		activities.remove(activity);
	}
	
	public static Activity getActivityy() {
		return activityy;
	}
	public static void setActivityy(Activity activityy) {
		ActivityCollector.activityy = activityy;
	}
	public static void finishall()
	{
		for(Activity activity : activities)
		{
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}

}
