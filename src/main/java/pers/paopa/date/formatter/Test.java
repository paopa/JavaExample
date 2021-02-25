package pers.paopa.date.formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

public class Test {
    public static void main(String[] args) {
        DateTimeFormatter xxx = null;
        try{
            xxx = new DateTimeFormatterBuilder()
                    .appendPattern("yyasdfasdfyyYYYas;dlfkjasl;dkfj;aslkd MM d")
                    .parseDefaulting(ChronoField.ERA, 1)
                    .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                    .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                    .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                    .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                    .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                    .toFormatter()
                    .withResolverStyle(ResolverStyle.STRICT);
        }catch (Exception e){
            System.out.println("ss");
            e.printStackTrace();
        }

        System.out.println(LocalDateTime.parse("2020 11 23", xxx));
    }
}
