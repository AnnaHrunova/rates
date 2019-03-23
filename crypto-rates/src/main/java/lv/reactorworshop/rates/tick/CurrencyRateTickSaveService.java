package lv.reactorworshop.rates.tick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.Logger;
import reactor.util.Loggers;

@Service
public class CurrencyRateTickSaveService {

    private static final Logger log = Loggers.getLogger(CurrencyRateTickSaveService.class);

    @Autowired
    public CurrencyRateTickSaveService(CurrencyRateTickService rateService,
                                       CurrencyRateTickRepository repository) {
        rateService.getRatesTicks()
                   .map(rate -> CurrencyRateTick.builder()
                           .price(rate.getPrice())
                           .currency(rate.getCurrency())
                           .createdAt(rate.getCreatedAt())
                           .build())
                   .flatMap(repository::save)
                   .subscribe(saved -> log.info("{} : {}", saved.getCurrency(), saved.getPrice().toPlainString()));
    }
}
