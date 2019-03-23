package lv.reactorworkshop.rates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.util.Logger;
import reactor.util.Loggers;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@Controller
public class RatesController {

    private static final Logger log = Loggers.getLogger(RatesController.class);

    private final Flux<CurrencyRateTickRepresentation> rates;

    public RatesController() {
        this.rates = WebClient.create("http://localhost:8080")
                              .get()
                              .uri("/rates")
                              .accept(APPLICATION_STREAM_JSON)
                              .retrieve()
                              .bodyToFlux(CurrencyRateTickRepresentation.class)
                              .share()
                              .onBackpressureDrop();
    }

    @GetMapping("rates")
    public String quotes() {
        return "rates";
    }

    @GetMapping(path = "rates/all", produces = TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<CurrencyRateTickRepresentation> getRates() {
        return rates;
    }

}
