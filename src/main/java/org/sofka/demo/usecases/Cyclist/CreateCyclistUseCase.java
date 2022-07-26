package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.CyclistMapper;
import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@Service
@Validated
@AllArgsConstructor
public class CreateCyclistUseCase{

    private final CyclistMapper cyclistMapper;
    private final CyclistRepository cyclistRepository;

    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        return cyclistRepository
                .save(cyclistMapper.convertCyclistDTOToCyclist(cyclistDTO))
                .map(cyclistMapper::convertCyclistToCyclistDTO);
    }
}
