package per.pao.practice.spi;

import per.pao.practice.api.Quote;
import per.pao.practice.api.QuoteManger;

import java.time.LocalDate;
import java.util.List;

public class YahooFinanceExchangeRateProvider
        implements ExchangeRateProvider
{
    @Override
    public QuoteManger create()
    {
        return new YahooQuoteManager();
    }

    public static class YahooQuoteManager
            implements QuoteManger
    {

        @Override
        public List<Quote> getQuotes(String baseCurrency, LocalDate date)
        {
            System.out.println("fetch data from Yahoo API");
            return List.of(new Quote(baseCurrency + "-YAHOO", date));
        }
    }
}
