package org.sofka.demo.usecases.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IDelete {
    Mono<Void> apply(String id);
}
