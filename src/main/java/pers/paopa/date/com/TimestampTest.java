package pers.paopa.date.com;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.Calendar;

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
//        for (TimestampRangeEnum rangeEnum : TimestampRangeEnum.values()) {
//            System.out.println(rangeEnum.getTimestamp() + " " + rangeEnum.getPoint());
//        }
//
//        for (TimestampSplit sp : TimestampSplit.values()) {
//            System.out.println(sp.getSecond() + " " + sp.getPoint());
//        }

        System.out.println(TimestampPointUtil.getIsTimestampPoint("631151999"));
    }
}

class TimestampPointUtil {

    public static final TimestampRangeEnum[] TIMESTAMP_RANGE_ARRAY = TimestampRangeEnum.values();

    private static final TimestampSplit[] SPLIT_ARRAY = TimestampSplit.values();

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
        for (TimestampRangeEnum time : TIMESTAMP_RANGE_ARRAY) {
            if (timestampLong < time.getTimestamp()) {
                return time.getPoint();
            }
        }
        return 0;
    }

    private static int checkSplitPoint(long timestampLong) {
        if (timestampLong == 0) {
            return 0;
        }
        for (TimestampSplit split : SPLIT_ARRAY) {
            if (timestampLong % split.getSecond() == 0) {
                return split.getPoint();
            }
        }
        return 0;
    }

}

enum TimestampRangeEnum {
    RANGE_MIN(631152000, 0),
    RANGE_ONE(946684800, 1),
    RANGE_TWO(1262304000, 3),
    RANGE_THREE((System.currentTimeMillis() / 1000), 5),
    RANGE_FOUR(getTimestampAfterYears(5), 3),
    RANGE_MAX(getTimestampAfterYears(10), 1);

    private long timestamp;
    private int point;

    TimestampRangeEnum(long timestamp, int point) {
        this.point = point;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getPoint() {
        return this.point;
    }

    private static long getTimestampAfterYears(int year) {
        Calendar pastTenYear = Calendar.getInstance();
        pastTenYear.add(Calendar.YEAR, year);
        return pastTenYear.getTimeInMillis() / 1000;
    }
}

enum TimestampSplit {
    DAY(86400, 8),
    HOUR(3600, 5),
    MINUTE(60, 3);

    private int second;
    private int point;

    TimestampSplit(int second, int point) {
        this.second = second;
        this.point = point;
    }

    public int getSecond() {
        return this.second;
    }

    public int getPoint() {
        return this.point;
    }
}