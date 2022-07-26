package org.sofka.demo.usecases.Team;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.TeamMapper;
import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.repository.TeamRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetTeamsByCountryUseCase {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDTO> getTeamsByCountry(String country){
        return teamRepository.findByCountry(country).map(teamMapper::convertTeamToTeamDTO)
                .switchIfEmpty(Mono.error(() -> new IllegalArgumentException("Unable to find the team based on the country")));
    }

}
