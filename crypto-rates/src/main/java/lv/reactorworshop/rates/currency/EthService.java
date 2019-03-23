package lv.reactorworshop.rates.currency;

import lv.reactorworshop.rates.tick.CurrencyRateTickRepresentation;
import lv.reactorworshop.rates.tick.CurrencyRateTickService;
import lv.reactorworshop.rates.utils.CurrencyRateTickGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Duration;

@Service
public class EthService implements CurrencyRateTickService {

    private final Flux<CurrencyRateTickRepresentation> rates;
    private final CurrencyRateTickGenerator rateTickGenerator;

    @Autowired
    public EthService(Clock clock){
        this.rateTickGenerator = new CurrencyRateTickGenerator("ETH", new BigDecimal("880.17"), clock);
        this.rates = Flux
                .interval(Duration.ofMillis(500))
                .flatMap(next -> rateTickGenerator.generateTicks())
                .share()
                .onBackpressureDrop();
    }

    @Override
    public Flux<CurrencyRateTickRepresentation> getRatesTicks() {
        return rates;
    }
}
