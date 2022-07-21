package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.TeamMapper;
import org.sofka.demo.model.CyclistTeamDTO;
import org.sofka.demo.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetCyclistsByTeamCodeUseCase {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Mono<CyclistTeamDTO> getCyclistsByTeamCode(String teamCode){
        return teamRepository.findByTeamCode(teamCode).map(teamMapper::convertTeamToCyclistTeamDTO)
                .switchIfEmpty(Mono.error(() -> new IllegalArgumentException("Unable to find the cyclists based on the team code")));
    }

}
