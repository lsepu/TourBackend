package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.usecases.shared.interfaces.IDelete;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteCyclistUseCase implements IDelete {

    private CyclistRepository cyclistRepository;

    @Override
    public Mono<Void> apply(String id) {
        return cyclistRepository.deleteById(id);
    }
}
