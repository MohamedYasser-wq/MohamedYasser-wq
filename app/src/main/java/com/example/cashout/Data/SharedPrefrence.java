package com.example.cashout.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrence {

    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_Trip_Id = "Trip_Id";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;


    public static void init(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public static void setUserHistoryGoing(String date) {
        editor.putString(KEY_Trip_Id, date).apply();
    }

    public static String getUserHistoryGoing() {
        return sharedPreferences.getString(KEY_Trip_Id, "");
    }

}
