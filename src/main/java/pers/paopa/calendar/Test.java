package pers.paopa.calendar;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();
        System.out.println(now.get(Calendar.YEAR));
        System.out.println(getMonth(now.get(Calendar.MONTH)));

        // set time
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, 1); // 目前時間加1個月
        calendar.add(Calendar.HOUR, 3); // 目前時間加3小時
        calendar.add(Calendar.YEAR, -2); // 目前時間減2年
        calendar.add(Calendar.DAY_OF_WEEK, 3); // 目前的時間加3天
        System.out.println(calendar.getTime());

        calendar.roll(Calendar.MONTH, 2);
        System.out.println(calendar.getTime());

    }

    private static String getMonth(int month) {
        return switch (month) {
            case Calendar.JANUARY -> "January";
            case Calendar.FEBRUARY -> "February";
            default -> "no";
        };
    }
}
