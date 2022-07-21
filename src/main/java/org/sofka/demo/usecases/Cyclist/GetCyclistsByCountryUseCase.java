package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.CyclistMapper;
import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class GetCyclistsByCountryUseCase {

    private final CyclistRepository cyclistRepository;
    private final CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> getCyclistsByCountry(String country){
        return cyclistRepository.findByCountry(country).map(cyclist -> cyclistMapper.convertCyclistToCyclistDTO(cyclist))
                .switchIfEmpty(Mono.error(() -> new Exception("Unable to find the cyclist based on the country")));
    }

}
