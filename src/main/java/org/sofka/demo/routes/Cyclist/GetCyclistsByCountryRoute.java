package org.sofka.demo.routes.Cyclist;


import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.usecases.Cyclist.GetCyclistsByCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCyclistsByCountryRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistsByCountry(GetCyclistsByCountryUseCase getCyclistsByCountry){
        return route(GET("/api/v1/cyclist/{country}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(getCyclistsByCountry.getCyclistsByCountry(request.pathVariable("country")),
                                CyclistDTO.class))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }
}