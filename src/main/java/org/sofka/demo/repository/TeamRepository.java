package org.sofka.demo.repository;

import org.sofka.demo.collection.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

    Flux<Team> findByCountry(String country);

    Mono<Team> findByTeamCode(String teamCode);

}
