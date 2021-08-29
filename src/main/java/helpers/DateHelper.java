package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateHelper {

    private static DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

    public static String getCurrentDay() {
        Date date = new Date();
        String currentDayFormatted = dateFormat.format(date);
        return currentDayFormatted;
    }

    public static String getDayFromToday(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, day);
        String dateFormatted = dateFormat.format(calendar.getTime());
        return dateFormatted;
    }
}


