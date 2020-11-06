package pers.paopa.date.com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateTimeFormatterTest {
    private static List<DateTimeFormatter> formatterList;

    public static final List<String> datePatternList = Arrays.asList(
            "d/M/y,h:m:s a",
            "d/M/y h:m:s a",
            "y/M/d H:m",
            "M d,y h:m:s a",
            "M/d/y H:m",
            "d/m-y H:m:s",
            "d.m.y H:m:s",
            "d M y",
            "y H:m:s a"
    );

    public DateTimeFormatterTest() {
        formatterList = datePatternList.stream()
                .map(pattern -> new DateTimeFormatterBuilder()
                        .appendPattern(pattern)
                        .parseDefaulting(ChronoField.ERA, 1)
                        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                        .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                        .parseDefaulting(ChronoField.HOUR_OF_AMPM, 0)
                        .toFormatter(Locale.ROOT)
                        .withResolverStyle(ResolverStyle.STRICT))
                .collect(Collectors.toList());
    }

    private static void getPatternInList(String datetime) {
        for (int index = 0; index < formatterList.size(); index++) {
            DateTimeFormatter formatter = formatterList.get(index);
            try {
                System.out.println(datetime + " format " + datePatternList.get(index));
                LocalDateTime.parse(datetime, formatter);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void example() {
        try {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern("dd/MM/yyyy a")
                    .parseDefaulting(ChronoField.HOUR_OF_AMPM, 0) // this is required
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) // optional, but you can set other value
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) // optional as well
                    .toFormatter(Locale.ROOT);
            System.out.println(LocalDateTime.parse("17/02/2015 PM", formatter)); // 2015-02-17T12:00
            System.out.println(LocalDateTime.parse("17/02/2015 AM", formatter)); // 2015-02-17T00:00
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new DateTimeFormatterTest();
        String datetime = "16/11/2019,05:20:38 AM";
//        String datetime = "16/11/2019 05:20:38 AM";
//        String datetime = "2019/11/16 15:20";
//        String datetime = "11 16,2019 05:20:38 AM";
//        String datetime = "11/16/2019 05:20";
//        String datetime = "16/11-2019 15:20:38";
//        String datetime = "16.11.2019 05:20:38";
//        String datetime = "16 11 2019";
//        String datetime = "11 16,2019 05:20:38 AM";
//        String datetime = "11 16,2019 05:20:38 AM";
        getPatternInList(datetime);
//        example();
    }
}
