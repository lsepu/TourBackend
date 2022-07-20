package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.TeamMapper;
import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.repository.TeamRepository;
import org.sofka.demo.usecases.Team.interfaces.ICreateTeam;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class UpdateTeamUseCase implements ICreateTeam {

    private TeamMapper teamMapper;
    private TeamRepository teamRepository;

    @Override
    public Mono<TeamDTO> apply(@Valid TeamDTO teamDTO) {
        return teamRepository
                .save(teamMapper.convertTeamDTOToTeam(teamDTO))
                .map(team -> teamMapper.convertTeamToTeamDTO(team));
    }
}
