package pers.paopa.date.com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertYearToACTest {

    public static void main(String[] args) {
        String input = "107-9-12 00:00:00";
        ConvertYearToACTest test = new ConvertYearToACTest();
        test.test(input, Set.of());
//        example();
    }

    public static final List<String> datePatternList = Arrays.asList(
            "y M", "y-M", "y/M",
            "y M d", "y-M-d", "y/M/d",
            "d M y", "d-M-y", "d/M/y",
            "M d y", "M-d-y", "M/d/y",
            "y-M-d H:m:s", "d-M-y-H:m:s", "d-M-y-H:m:s-a",
            "y-M-d H:m:s.SSS", "y-M-d H:m:s-SSS",
            "y-M-d H:m:s.SSSSSS", "y-M-d H:m:s-SSSSSS",
            "y-M-d H:m:s.SSSSSSSSS", "y-M-d H:m:s-SSSSSSSSS",
            "y/M/d H:m:s.SSS", "y/M/d H:m:s-SSS",
            "y/M/d H:m:s.SSSSSS", "y/M/d H:m:s-SSSSSS",
            "y/M/d H:m:s.SSSSSSSSS", "y/M/d H:m:s-SSSSSSSSS",
            "y/M/d H:m", "M/d/y H:m", "M/d/y H:m:s",
            "d/m-y H:m:s", "d.m.y H:m:s", "d/M/y H:m:s",
            "M d,y H:m:s a", "M d,y h:m:s a", "d/M/y,H:m:s a",
            "d/M/y,h:m:s a", "d/M/y H:m:s a", "d/M/y h:m:s a",
            "y年M月d日H時m分s秒", "y年 M月 d日 H時 m分 s秒", "y 年 M 月 d 日 H 時 m 分 s 秒",
            "y年M月d日H时m分s秒", "y年 M月 d日 H时 m分 s秒", "y 年 M 月 d 日 H 时 m 分 s 秒",
            "M月-y", "d-M月-y", "y年M月"
    );

    private final List<DateTimeFormatter> formatterList;

    public ConvertYearToACTest() {
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
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT))
                .collect(Collectors.toList());
    }

    private void test(String input, Set<String> datePatterns) {
        for (String datePattern : datePatterns) {
            try {
                DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                        .appendPattern(datePattern)
                        .parseDefaulting(ChronoField.ERA, 1)
                        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                        .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                        .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                        .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                        .toFormatter()
                        .withResolverStyle(ResolverStyle.STRICT);
                LocalDateTime.parse(input, dateTimeFormatter);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for (int index = 0; index < formatterList.size(); index++) {
            DateTimeFormatter formatter = formatterList.get(index);

            try {
                LocalDateTime.parse(input, formatter);
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void example() {
        Chronology chrono = MinguoChronology.INSTANCE;
        DateTimeFormatter df = new DateTimeFormatterBuilder()
                .parseLenient()
                .appendPattern("yyy/MM/dd")
                .toFormatter()
                .withChronology(chrono)
                .withDecimalStyle(DecimalStyle.of(Locale.getDefault()));

        ChronoLocalDate d1 = chrono.date(df.parse("108/08/06"));
        ChronoLocalDate d2 = chrono.date(df.parse("98/08/06"));

        LocalDate ld1 = LocalDate.from(d1);
        LocalDate ld2 = LocalDate.from(d2);

        System.out.println(ld1);               // 2019-08-06
        System.out.println(ld2);               // 2009-08-06
        System.out.println(ld1.format(df));    // 108/08/06


    }
}
