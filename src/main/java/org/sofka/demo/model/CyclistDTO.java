package org.sofka.demo.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CyclistDTO {

    private String id;
    @NotBlank
    private String fullName;
    @NotBlank
        @Size(max = 3, message="The length of the number cannot be greater than 3")
    private String competitorNumber;
    @NotBlank
    private String country;

}
