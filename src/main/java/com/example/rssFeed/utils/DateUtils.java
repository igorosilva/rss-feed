package com.example.rssFeed.utils;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

public class DateUtils {

    public static LocalDateTime StringToLocalDateTime(String date) {
        return LocalDateTime.parse(date, RFC_1123_DATE_TIME);
    }
}
