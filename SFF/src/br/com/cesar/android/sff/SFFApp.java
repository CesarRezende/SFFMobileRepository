package br.com.cesar.android.sff;

import android.app.Application;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SFFApp extends Application {
    private static int menuPosition;
    private static int yearMonth;
    private static int year;
    private static int month;

    static {
        yearMonth = 0;
        menuPosition = 0;
    }

    public static void setYearMonth(Calendar date) {
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MM", new Locale("pt", "BR"));
        year = Integer.valueOf(new SimpleDateFormat("yyyy", new Locale("pt", "BR")).format(date.getTime())).intValue();
        month = Integer.valueOf(monthFormatter.format(date.getTime()));
        yearMonth = (year * 100) + month;
    }


	public static int getYearMonth() {
        return yearMonth;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onTerminate() {
        super.onTerminate();
    }

    public static int getMenuPosition() {
        return SFFApp.menuPosition;
    }

    public static void setMenuPosition(int menuPosition) {
    	SFFApp.menuPosition = menuPosition;
    }
    
    public static int getYear() {
		return year;
	}

	public static int getMonth() {
		return month;
	}

}

