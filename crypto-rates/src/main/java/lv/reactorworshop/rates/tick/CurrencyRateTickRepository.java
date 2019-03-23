package lv.reactorworshop.rates.tick;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface CurrencyRateTickRepository extends ReactiveMongoRepository<CurrencyRateTick, String> {
}
