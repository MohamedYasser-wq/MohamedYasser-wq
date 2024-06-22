package com.example.cashout.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String formatDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (Calendar.getInstance().get(Calendar.YEAR) == c.get(Calendar.YEAR) &&
                Calendar.getInstance().get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR)) {
            SimpleDateFormat formatter = new SimpleDateFormat("h:mm a", Locale.getDefault());
            return "Today - " + formatter.format(date);
        }else if(Calendar.getInstance().get(Calendar.YEAR) == c.get(Calendar.YEAR) &&
                Calendar.getInstance().get(Calendar.DAY_OF_YEAR)-1 == c.get(Calendar.DAY_OF_YEAR)){
            SimpleDateFormat formatter = new SimpleDateFormat("h:mm a", Locale.getDefault());
            return "Yesterday - " + formatter.format(date);
        }else{
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy",Locale.getDefault());
            return formatter.format(date);
        }
    }
    public static Boolean isToday(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return Calendar.getInstance().get(Calendar.YEAR) == c.get(Calendar.YEAR) &&
                Calendar.getInstance().get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
    }
}
