package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.repository.TeamRepository;
import org.sofka.demo.usecases.interfaces.IDelete;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteTeamUseCase implements IDelete {

    private final TeamRepository teamRepository;

    @Override
    public Mono<Void> apply(String id) {
        return teamRepository.deleteById(id);
    }
}
