package com.example.cashout.Data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrence {

    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_FirstName = "FirstName";
    private static final String KEY_SecondName = "SecondName";
    private static final String KEY_Gender = "Gender";
    private static final String KEY_National_Id = "National_Id";
    private static final String KEY_Address = "Address";
    private static final String KEY_BirthDay = "BirthDay";
    private static final String KEY_imageUri = "imageUri";
    private static final String User_Token = "Token";
    private static final String FIRST_TIME_KEY = "FirstTime";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void init(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    public static boolean isFirstTime() { return sharedPreferences.getBoolean(FIRST_TIME_KEY, true);}
    public static void firstTimeDone(){sharedPreferences.edit().putBoolean(FIRST_TIME_KEY, false).apply();}
    public static void setFirstName(String FirstName) {
        editor.putString(KEY_FirstName, FirstName).apply();
    }

    public static String getFirstName() {
        return sharedPreferences.getString(KEY_FirstName, "");
    }


    public static void setSecondName(String SecondName) {
        editor.putString(KEY_SecondName, SecondName).apply();
    }

    public static String getSecondName() {
        return sharedPreferences.getString(KEY_SecondName, "");
    }

    public static void setGender(String Gender) {
        editor.putString(KEY_Gender, Gender).apply();
    }

    public static String getGender() {
        return sharedPreferences.getString(KEY_Gender, "");
    }

    public static void setNational_Id(String National_Id) {
        editor.putString(KEY_National_Id, National_Id).apply();
    }

    public static String getNational_Id() {
        return sharedPreferences.getString(KEY_National_Id, "");
    }

    public static void setAddress(String Address) {
        editor.putString(KEY_Address, Address).apply();
    }

    public static String getAddress() {
        return sharedPreferences.getString(KEY_Address, "");
    }

    public static void setBirthDay(String BirthDay) {
        editor.putString(KEY_BirthDay, BirthDay).apply();
    }

    public static String getBirthDay() {
        return sharedPreferences.getString(KEY_BirthDay, "");
    }


    public static void setImageUri(String KEY_imageUri) {
        editor.putString(KEY_imageUri, KEY_imageUri).apply();
    }

    public static String getImageUri() {
        return sharedPreferences.getString(KEY_imageUri, "");
    }


    public static void setUserToken(String Token) {
        editor.putString(User_Token, Token).apply();
    }

    public static String getUser_Token() {
        return sharedPreferences.getString(User_Token, "");
    }


}
