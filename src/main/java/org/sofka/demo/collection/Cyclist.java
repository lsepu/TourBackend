package org.sofka.demo.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cyclist")
public class Cyclist {

    @Id
    private String id;
    private String fullName;
    private String competitorNumber;
    private String Country;

}
