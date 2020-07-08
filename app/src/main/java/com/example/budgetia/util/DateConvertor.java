package com.example.budgetia.util;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConvertor {


    @TypeConverter
    public static Long toTimestamp(Date date){
        return date==null?null : date.getTime();

    }

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null ? null : new Date(timestamp);
    }
}
