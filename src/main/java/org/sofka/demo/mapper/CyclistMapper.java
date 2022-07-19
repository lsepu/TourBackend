package org.sofka.demo.mapper;

import org.modelmapper.ModelMapper;
import org.sofka.demo.collection.Cyclist;
import org.sofka.demo.model.CyclistDTO;
import org.springframework.stereotype.Component;

@Component
public class CyclistMapper {

    private ModelMapper modelMapper;

    public CyclistMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CyclistDTO convertCyclistToCyclistDTO(Cyclist cyclist){
        return modelMapper.map(cyclist, CyclistDTO.class);
    }

    public Cyclist convertCyclistDTOToCyclist(CyclistDTO cyclistDTO){
        return modelMapper.map(cyclistDTO, Cyclist.class);
    }
}
