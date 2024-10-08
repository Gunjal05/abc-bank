package com.abc;

import java.util.Calendar;
import java.util.Date;

public class DateProvider {
    private static DateProvider instance = null;

    public static DateProvider getInstance() {
        if (instance == null)
            instance = new DateProvider();
        return instance;
    }
    // Allow setting a mock instance for testing
     public static void setInstance(DateProvider dateProvider){
     instance = provider;
     }

    public Date now() {
        return Calendar.getInstance().getTime();
    }
}
