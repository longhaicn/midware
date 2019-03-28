package com.poly.midware.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: midware
 * @Package: com.poly.midware.utils
 * @Author: longhai
 * @CreateDate: 2018/5/31 15:11
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class DateTimeUtils {

    public static Date getDate() {

        return new Date();
    }



    public static String getDateStr() {
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return time.format(new Date());
    }

    public static String getDateTimeStr() {
        SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");

        return time.format(new Date());
    }

    public static String formatDateStr(Date date) {

        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        return time.format(date);

    }

    public static Date parseDateStr(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;

    }


}
