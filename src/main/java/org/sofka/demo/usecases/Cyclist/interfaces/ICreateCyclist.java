package org.sofka.demo.usecases.Cyclist.interfaces;

import org.sofka.demo.model.CyclistDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ICreateCyclist {
    Mono<CyclistDTO> apply(CyclistDTO cyclistDTO);
}
