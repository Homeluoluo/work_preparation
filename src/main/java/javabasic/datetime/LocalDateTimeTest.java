package javabasic.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * @Classname LocalDateTimeTest
 * @Description TODO
 * @Date 2020/3/26 18:45
 * @Created by luojia
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        test();
    }

    public static void LocalDateTest(){
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);
        //获取年月日 星期几
        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year+"  "+year1);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
    }

    public static void LocalTimeTest(){
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();
        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getMinute();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
    }

    public static void LocalDateTimeTest(){
        //创建LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime localDateTime3 = LocalDate.now().atTime(LocalTime.now());
        LocalDateTime localDateTime4 = LocalTime.now().atDate(LocalDate.now());

        //获取LocalDate
        LocalDate localDate2 = localDateTime.toLocalDate();
        //获取LocalTime
        LocalTime localTime = localDateTime.toLocalTime();

        System.out.println(localDateTime);
        System.out.println(localDateTime.getSecond());

    }

    public static void InstantTest(){
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
    }

    public static void test(){
        LocalDate localDate2 = LocalDate.now();
        LocalDate localDate1 = localDate2.with(firstDayOfMonth());
        System.out.println(localDate1);

        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
//自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);
        System.out.println(s3);
    }
}
