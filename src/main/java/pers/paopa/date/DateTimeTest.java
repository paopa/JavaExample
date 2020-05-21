package pers.paopa.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString_01 = "2016-01-01";
        String dateString_02 = "yyyy-MM-dd";
        try {
            Date date_01 = sdf.parse(dateString_01);
            Date date_02 = sdf.parse(dateString_02);
            System.out.println(date_01.before(date_02)); //true，當 date_01 小於 date_02 時，為 true，否則為 false
            System.out.println(date_02.after(date_01)); //true，當 date_02 大於 date_01 時，為 true，否則為 false
            System.out.println(date_01.compareTo(date_02)); //-1，當 date_01 小於 date_02 時，為 -1
            System.out.println(date_02.compareTo(date_01)); //1，當 date_02 大於 date_01 時，為 1
            System.out.println(date_02.compareTo(date_02)); //0，當兩個日期相等時，為 0
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
