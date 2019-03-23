package lv.reactorworshop.rates.utils;

import lv.reactorworshop.rates.tick.CurrencyRateTickRepresentation;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Random;

public class CurrencyRateTickGenerator {

    private final MathContext mathContext;

    private final String currency;

    private final Random random;

    private final BigDecimal price;

    private final Clock clock;

    public CurrencyRateTickGenerator(String currency, BigDecimal initialPrice, Clock clock) {
        this.currency = currency;
        this.price = initialPrice;
        this.mathContext = new MathContext(2);
        this.random = new Random();
        this.clock = clock;
    }

    public Flux<CurrencyRateTickRepresentation> generateTicks() {
        return Flux.range(0, 1)
                   .map(this::generatePrice)
                   .map(price -> CurrencyRateTickRepresentation.builder()
                            .price(price)
                            .currency(currency)
                            .createdAt(LocalDateTime.now(clock))
                            .build());
    }

    private BigDecimal generatePrice(int i) {
        BigDecimal changePercent = new BigDecimal(0.5 * random.nextDouble());
        BigDecimal changeValue = price.multiply(changePercent, mathContext);
        if (i % 2 == 0) {
            return price.add(changeValue, mathContext);
        }
        return price.subtract(changeValue, mathContext);
    }

}
