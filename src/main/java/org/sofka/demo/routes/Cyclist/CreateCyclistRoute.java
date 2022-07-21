package org.sofka.demo.routes.Cyclist;

import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.usecases.Cyclist.CreateCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.util.function.Function;

@Configuration
public class CreateCyclistRoute {

    @Bean
    RouterFunction<ServerResponse> createCyclist(CreateCyclistUseCase createCyclistUseCase){
        Function<CyclistDTO, Mono<ServerResponse>> executor =
                cyclistDTO -> createCyclistUseCase.apply(cyclistDTO)
                        .flatMap(result-> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result));

        return route(POST("/api/v1/cyclist/add")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class).flatMap(executor))  ;
    }

}
