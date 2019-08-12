package br.com.clebersantos.anbima.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Create by Cleber Santos on 07/08/2019
 */
public class DateUtilConvert {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public Timestamp transformStringToTimestamp(String date) {
        return Timestamp.valueOf(date);
    }

    public String transformTimestampToString(Timestamp timestamp) {
        return dateFormatter.format(timestamp);
    }
}
