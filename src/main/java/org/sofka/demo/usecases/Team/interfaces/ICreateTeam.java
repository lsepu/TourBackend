package org.sofka.demo.usecases.Team.interfaces;

import org.sofka.demo.model.TeamDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateTeam {
    Mono<TeamDTO> apply (TeamDTO teamDTO);
}
