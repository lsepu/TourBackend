package org.sofka.demo.usecases.Cyclist;

import lombok.AllArgsConstructor;
import org.sofka.demo.mapper.CyclistMapper;
import org.sofka.demo.model.CyclistDTO;
import org.sofka.demo.repository.CyclistRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllCyclistsUseCase {

    private CyclistRepository cyclistRepository;
    private CyclistMapper cyclistMapper;

    public Flux<CyclistDTO> get(){
        return cyclistRepository.findAll().map(cyclistMapper::convertCyclistToCyclistDTO);
    }

}
