package per.pao.practice.api;

import java.time.LocalDate;
import java.util.List;

public interface QuoteManger
{
    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
