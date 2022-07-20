package org.sofka.demo.usecases.shared.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IDelete {
    Mono<Void> apply(String id);
}
