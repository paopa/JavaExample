package pers.pao.date.simple;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatetimeFormatTest {
    public static void main(String[] args) throws ParseException {
        String test = "2020-04-17 20:29:12.010000000";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.sssssssss");
        Date date = sdf.parse(test);
        SimpleDateFormat xx = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS.sss");
        String originalValuex = xx.format(date);
        System.out.println(originalValuex);
    }
}
