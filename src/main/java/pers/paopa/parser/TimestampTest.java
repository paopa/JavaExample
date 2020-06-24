package pers.paopa.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class TimestampTest {
    public static void main(String[] args) throws ParseException {
        // 315532800 10
        // 157766400 5
        // 631152000 :1990
        // 946684800 :2000
        // 1262304000 :2010
        // 1592975565 :2020
        // 1750741965 :2025
        // 1908508365 :2030
        System.out.println(TimestampPointUtil.getIsTimestampPoint("1908508365"));
    }
}

class TimestampPointUtil {

    public static final long[] TIMESTAMP_RANGE = {
            631152000,//1990:0
            946684800,//2000:1
            1262304000,//2010:3
            (System.currentTimeMillis() / 1000),//now:5
            (getTimestampAfterYears(5)),//now+5:3
            (getTimestampAfterYears(10))//now+10:1
    };

    private static final long[] SPLIT_ARRAY = {
            86400,//day:8
            3600,//hour:5
            60//minute:3
    };

    public static long getIsTimestampPoint(String timestampString) {
        try {
            if (timestampString == null) {
                return 0;
            }
            long timestampLong = Long.parseLong(timestampString);
            if (timestampLong < 0) {
                return 0;
            }
            if (timestampString.length() > 10) {
                timestampLong = timestampLong / 1000;
            }
            return checkTimeRangePoint(timestampLong) + checkSplitPoint(timestampLong);
        } catch (DateTimeParseException | NumberFormatException ignored) {
            /* if error input is not timestamp */
        }
        return 0;
    }

    private static int checkTimeRangePoint(long timestampLong) {
        int range = 0;
        for (long time : TIMESTAMP_RANGE) {
            if (timestampLong < time) {
                switch (range) {
                    case 0:
                        return 0;
                    case 1:
                    case 5:
                        return 1;
                    case 2:
                    case 4:
                        return 3;
                    case 3:
                        return 5;
                }
            }
            range++;
        }
        return 0;
    }

    private static int checkSplitPoint(long timestampLong) {
        if (timestampLong == 0) {
            return 0;
        }
        for (long split : SPLIT_ARRAY) {
            if (timestampLong % split == 0) {
                switch ((int) split) {
                    case 86400:
                        return 8;
                    case 3600:
                        return 5;
                    case 60:
                        return 3;
                }
            }
        }
        return 0;
    }

    private static long getTimestampAfterYears(int year) {
        Calendar pastTenYear = Calendar.getInstance();
        pastTenYear.add(Calendar.YEAR, year);
        return pastTenYear.getTimeInMillis() / 1000;
    }
}
