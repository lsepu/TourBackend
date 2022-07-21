package org.sofka.demo.mapper;

import org.modelmapper.ModelMapper;
import org.sofka.demo.collection.Team;
import org.sofka.demo.model.CyclistTeamDTO;
import org.sofka.demo.model.TeamDTO;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    private ModelMapper modelMapper;

    public TeamMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TeamDTO convertTeamToTeamDTO(Team team){
        return modelMapper.map(team, TeamDTO.class);
    }

    public Team convertTeamDTOToTeam(TeamDTO teamDTO){
        return modelMapper.map(teamDTO, Team.class);
    }

    public CyclistTeamDTO convertTeamToCyclistTeamDTO(Team team){return modelMapper.map(team, CyclistTeamDTO.class);}


}
