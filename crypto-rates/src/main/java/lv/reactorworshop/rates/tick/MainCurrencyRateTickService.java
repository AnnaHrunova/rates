package lv.reactorworshop.rates.tick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
public class MainCurrencyRateTickService implements CurrencyRateTickService {

    private Flux<CurrencyRateTickRepresentation> rates;

    @Autowired
    public MainCurrencyRateTickService(Set<CurrencyRateTickService> tickRateServices) {
        List<Flux<CurrencyRateTickRepresentation>> fluxes = tickRateServices
                .stream()
                .map(CurrencyRateTickService::getRatesTicks)
                .collect(Collectors.toList());
        this.rates = Flux.merge(fluxes)
                         .share()
                         .onBackpressureDrop();
    }

    @Override
    public Flux<CurrencyRateTickRepresentation> getRatesTicks() {
        return rates;
    }
}
