package lv.reactorworshop.rates.tick;

import reactor.core.publisher.Flux;

public interface CurrencyRateTickService {

    Flux<CurrencyRateTickRepresentation> getRatesTicks();

}
