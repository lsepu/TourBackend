package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.CyclistMapper;
import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.repository.CyclistRepository;
import org.sofka.demo.usecases.Cyclist.interfaces.ICreateCyclist;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Service
@Validated
@AllArgsConstructor
public class UpdateCyclistUseCase implements ICreateCyclist {

    private CyclistMapper cyclistMapper;
    private CyclistRepository cyclistRepository;

    @Override
    public Mono<CyclistDTO> apply(@Valid CyclistDTO cyclistDTO) {
        return cyclistRepository
                .save(cyclistMapper.convertCyclistDTOToCyclist(cyclistDTO))
                .map(cyclist -> cyclistMapper.convertCyclistToCyclistDTO(cyclist));
    }

}
