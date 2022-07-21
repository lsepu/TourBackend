package org.sofka.demo.routes.Team;

import org.sofka.demo.model.TeamDTO;
import org.sofka.demo.usecases.Team.GetTeamsByCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetTeamsByCountryRoute {

    @Bean
    public RouterFunction<ServerResponse> getTeamsByCountry(GetTeamsByCountryUseCase getTeamsByCountry){
        return route(GET("/api/v1/team/country/{country}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getTeamsByCountry.getTeamsByCountry(request.pathVariable("country")),
                                TeamDTO.class)));
    }

}
