package lv.reactorworkshop.rates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateTickRepresentation {

    private BigDecimal price;

    private String currency;

    private LocalDateTime createdAt;
}
