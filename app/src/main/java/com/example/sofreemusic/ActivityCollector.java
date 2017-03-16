package com.example.sofreemusic;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lgh on 2017/3/16.
 */

public class ActivityCollector {
    public static List<Activity> activityies = new ArrayList<>();
    public static void addActivity(Activity activity){
        activityies.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityies.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity:activityies) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
