package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.TeamMapper;
import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class CreateTeamUseCase {

    private final TeamMapper teamMapper;
    private final TeamRepository teamRepository;


    public Mono<TeamDTO> apply(@Valid TeamDTO teamDTO) {
        return teamRepository
                .save(teamMapper.convertTeamDTOToTeam(teamDTO))
                .map(teamMapper::convertTeamToTeamDTO);
    }
}
