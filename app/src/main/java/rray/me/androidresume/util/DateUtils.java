package rray.me.androidresume.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

/**
 * Created by RRay on 7/19/2017.
 */

public class DateUtils {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy", Locale.CANADA);

    public static String dataToString(Date date) {
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String dateString) {
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(0);
        }
    }
}
