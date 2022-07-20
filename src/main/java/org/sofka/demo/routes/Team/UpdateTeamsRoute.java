package org.sofka.demo.routes.Team;


import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.usecases.Team.UpdateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateTeamsRoute {

    @Bean
    public RouterFunction<ServerResponse> updateTeam(UpdateTeamUseCase updateTeamUseCase){
        Function<TeamDTO, Mono<ServerResponse>> executor =
                teamDTO -> updateTeamUseCase.apply(teamDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(PUT("/api/v1/team/update")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request
                .bodyToMono(TeamDTO.class)
                .flatMap(executor));
    }

}
