package lv.reactorworshop.rates.tick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("rates")
public class CurrencyRateTickController {

    private final Flux<CurrencyRateTickRepresentation> rates;

    @Autowired
    public CurrencyRateTickController(CurrencyRateTickService rateService) {
        this.rates = rateService.getRatesTicks();
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<CurrencyRateTickRepresentation> getRates(){
        return rates;
    }
}
