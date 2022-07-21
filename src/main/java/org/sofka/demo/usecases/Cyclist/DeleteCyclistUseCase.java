package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteCyclistUseCase {

    private final CyclistRepository cyclistRepository;

    public Mono<Void> apply(String id) {
        return cyclistRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("cyclist does not exist")))
                .flatMap(team -> cyclistRepository.deleteById(id));
    }
}
