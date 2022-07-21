package org.sofka.demo.routes.Cyclist;

import org.sofka.demo.model.CyclistTeamDTO;
import org.sofka.demo.usecases.Cyclist.GetCyclistsByTeamCodeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistsByTeamCodeRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistByTeamCode(GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase){
        return route(GET("/api/v1/cyclist/teamcode/{teamCode}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getCyclistsByTeamCodeUseCase.getCyclistsByTeamCode(request.pathVariable("teamCode")),
                                CyclistTeamDTO.class))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }

}
