package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteTeamUseCase{

    private final TeamRepository teamRepository;

    public Mono<Void> apply(String id) {
        return teamRepository.deleteById(id);
    }
}
