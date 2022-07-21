package org.sofka.demo.model;

import lombok.Data;
import org.sofka.demo.collection.Cyclist;

import java.util.List;

@Data
public class CyclistTeamDTO {

    private String teamCode;
    private List<Cyclist> cyclists;

}
