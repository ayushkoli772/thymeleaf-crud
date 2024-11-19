package com.example.crudspring.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Item")
public class Item {
    @Id
    private String id;
    private String title;
    private String note;
    private int days;

}
