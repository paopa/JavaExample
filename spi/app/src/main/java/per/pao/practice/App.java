package per.pao.practice;

import per.pao.practice.api.Quote;
import per.pao.practice.spi.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        ExchangeRate.providers(false)
                .forEachRemaining(provider -> {
                    final List<Quote> list = provider.create().getQuotes("USA", LocalDate.now());
                    list.forEach(System.out::println);
                });
    }
}
