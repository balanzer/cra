/**
 *
 */
package com.ihg.it.pfm.serviceimpl.cra.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author varathm
 *
 */
public class DateUtils {

    public static String convertDate(Date input) {
        if (null != input) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MMM/dd");
            return format.format(input);
        }
        return null;
    }

    public static Date convertDate(String input) throws ParseException {
        if (null != input) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MMM/dd");
            return format.parse(input);
        }
        return null;
    }

    public static Date getCurrentDateTime() {
        return Calendar.getInstance().getTime();
    }

}
