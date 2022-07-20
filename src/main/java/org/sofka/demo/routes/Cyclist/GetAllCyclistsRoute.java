package org.sofka.demo.routes.Cyclist;

import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.usecases.Cyclist.GetAllCyclistsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistsRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclists(GetAllCyclistsUseCase getAllCyclistsUseCase){
        return route(GET("/api/v1/cyclist/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters .fromPublisher(getAllCyclistsUseCase.get(), CyclistDTO.class)));
    }

}
