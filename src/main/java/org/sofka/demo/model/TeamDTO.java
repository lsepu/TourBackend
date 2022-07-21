package org.sofka.demo.model;

import lombok.Data;
import org.sofka.demo.collection.Cyclist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TeamDTO {

    private String id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "team code is mandatory")
    @Size(max = 3)
        private String teamCode;
    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotNull
    @Size(max = 8)
    private List<Cyclist> cyclists;


}
