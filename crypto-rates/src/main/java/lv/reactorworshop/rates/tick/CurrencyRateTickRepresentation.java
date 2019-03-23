package lv.reactorworshop.rates.tick;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateTickRepresentation {

    private BigDecimal price;

    private String currency;

    private LocalDateTime createdAt;
}
