package org.sofka.demo.repository;

import org.sofka.demo.collection.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {

    Flux<Cyclist> findByCountry(String country);

}
