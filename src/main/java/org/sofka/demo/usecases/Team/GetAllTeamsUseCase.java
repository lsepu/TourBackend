package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.TeamMapper;
import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllTeamsUseCase {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDTO> get(){
        return teamRepository.findAll().map(teamMapper::convertTeamToTeamDTO);
    }

}
