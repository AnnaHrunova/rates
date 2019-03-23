package lv.reactorworshop.rates.tick;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
class CurrencyRateTick {

    @Id
    private String id;

    private BigDecimal price;

    private String currency;

    private LocalDateTime createdAt;
}
