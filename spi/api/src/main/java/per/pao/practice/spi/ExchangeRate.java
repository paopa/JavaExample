package per.pao.practice.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ExchangeRate
{
    private static final ServiceLoader<ExchangeRateProvider> LOADER
            = ServiceLoader.load(ExchangeRateProvider.class);

    public Iterator<ExchangeRateProvider> providers(boolean refresh)
    {
        if (refresh) {
            LOADER.reload();
        }
        return LOADER.iterator();
    }
}
