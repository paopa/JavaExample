package pers.pao.date.before;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date time = calendar.getTime();
        System.out.println(time);
        Date date = new Date();
        System.out.println(date.before(time));
    }
}
