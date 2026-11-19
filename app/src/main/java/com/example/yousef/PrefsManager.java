package com.example.yousef;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefsManager {
    private static final String KEY_NAME = "name";
    private static final String NOTIFICATIONS="notifications";
    private SharedPreferences prefs;


    public PrefsManager(Context context) {
// פתיחת קובץ ההגדרות במצב פרטי
        prefs = context.getSharedPreferences("MySettings", Context.MODE_PRIVATE); // the data is only stored in this app and cannot be accessed by other apps
    }
    public void name(String name){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_NAME, name);
        editor.apply();
    }

    public void notifications(boolean notifications){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(NOTIFICATIONS, notifications);
        editor.apply();

    }


}
