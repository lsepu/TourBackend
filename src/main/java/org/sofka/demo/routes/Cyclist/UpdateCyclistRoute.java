package org.sofka.demo.routes.Cyclist;

import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.usecases.Cyclist.UpdateCyclistUseCase;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class UpdateCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> updateCyclist(UpdateCyclistUseCase updateCyclistUseCase){
        Function<CyclistDTO, Mono<ServerResponse>> executor =
                cyclistDTO -> updateCyclistUseCase.apply(cyclistDTO)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(PUT("/api/v1/cyclist/update")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request
                .bodyToMono(CyclistDTO.class)
                .flatMap(executor));
    }

}
