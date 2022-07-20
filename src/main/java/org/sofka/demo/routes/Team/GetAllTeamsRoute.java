package org.sofka.demo.routes.Team;
import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.usecases.Team.GetAllTeamsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllTeamsRoute {

    @Bean
    public RouterFunction<ServerResponse> getTeams(GetAllTeamsUseCase getAllTeamsUseCase){
        return route(GET("/api/v1/team/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllTeamsUseCase.get(), TeamDTO.class)));
    }

}
