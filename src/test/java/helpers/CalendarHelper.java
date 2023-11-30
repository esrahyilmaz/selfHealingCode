package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * provides methods to get data/time in different formats
 *
 * @author Andrei Antipov
 */
public class CalendarHelper extends BaseClass {


    public static String getMM_DD_YYYY() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getYYYY_MM_DD() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss-SSS");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getTimeRepo() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getMin() {
        SimpleDateFormat formatter = new SimpleDateFormat("mm.ss");
        Date date = new Date();
        return formatter.format(date);
    }

    // get date in past/future by add positive  or negative months, days or years
    public static String getSystemDateMMDDYYYY(int months, int days, int years) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, months);
        c.add(Calendar.DATE, days);
        c.add(Calendar.YEAR, years);
        String output = sdf.format(c.getTime());
        return output;
    }

    public static String systemDateMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String output = sdf.format(c.getTime());
        return output;
    }

    public static String systemDateYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String output = sdf.format(c.getTime());
        return output;
    }

    public static String systemDateDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String output = sdf.format(c.getTime());
        return output;
    }

    public static String convertDateFormat(Date eiaf_CompletionDate) {
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MMM/yyyy");
        String stringDate = DateFor.format(eiaf_CompletionDate);
        log.info("Date Format with dd/MMM/yyyy : " + stringDate);
        return stringDate;
    }

    public static String getMonthByNum(String month) {
        if (month.equalsIgnoreCase("01") || month.equalsIgnoreCase("1")) {
            month = "January";
        } else if (month.equalsIgnoreCase("02") || month.equalsIgnoreCase("2")) {
            month = "February";
        } else if (month.equalsIgnoreCase("03") || month.equalsIgnoreCase("3")) {
            month = "March";
        } else if (month.equalsIgnoreCase("04") || month.equalsIgnoreCase("4")) {
            month = "April";
        } else if (month.equalsIgnoreCase("05") || month.equalsIgnoreCase("5")) {
            month = "May";
        } else if (month.equalsIgnoreCase("06") || month.equalsIgnoreCase("6")) {
            month = "June";
        } else if (month.equalsIgnoreCase("07") || month.equalsIgnoreCase("7")) {
            month = "July";
        } else if (month.equalsIgnoreCase("08") || month.equalsIgnoreCase("8")) {
            month = "August";
        } else if (month.equalsIgnoreCase("09") || month.equalsIgnoreCase("9")) {
            month = "September";
        } else if (month.equalsIgnoreCase("10")) {
            month = "October";
        } else if (month.equalsIgnoreCase("11")) {
            month = "November";
        } else if (month.equalsIgnoreCase("12")) {
            month = "December";
        }
        return month;
    }

    public static String getSystemDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:MM:SS");
        Date date = new Date();
        String formattedDate = formatter.format(date);
        log.info("Date and time: " + formattedDate);
        return formattedDate;
    }

    public static String getSystemDateMMDDYYYY() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String output = sdf.format(c.getTime());
        log.info("Date: " + output);
        return output;
    }

    public static String getSystemDateTimeInDbFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String output = sdf.format(c.getTime());
        log.info("Date: " + output);
        return output;
    }

    public static String getSystemDateDDMMMYYYY(int months, int days, int years) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, months);
        c.add(Calendar.DATE, days);
        c.add(Calendar.YEAR, years);
        String output = sdf.format(c.getTime());
        return output;
    }
}
