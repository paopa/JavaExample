package per.pao.practice.spi;

import per.pao.practice.api.QuoteManger;

public interface ExchangeRateProvider
{
    QuoteManger create();
}
