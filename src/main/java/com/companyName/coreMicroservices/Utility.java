package com.companyName.coreMicroservices;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.companyName.coreMicroservices.Constant.LAST_UPDATE_CLOSE_FORMAT;
import static com.companyName.coreMicroservices.Constant.LAST_UPDATE_TIMESTAMP_FORMAT;

public class Utility {
    public static String fromLocalDateTimeToLastUpdate(LocalDateTime dateTime){
        if (dateTime.getHour()==0 && dateTime.getMinute()==0){
            return fromLocalDateTimeToString(dateTime,LAST_UPDATE_CLOSE_FORMAT);
        } else {
            return fromLocalDateTimeToString(dateTime,LAST_UPDATE_TIMESTAMP_FORMAT);
        }
    }

    public static String fromLocalDateTimeToString(LocalDateTime date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    public static String fromDateToString(Date date, String format) {
        SimpleDateFormat dateParser = new SimpleDateFormat(format);
        return dateParser.format(date);
    }
}
