package com.tripaneer.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "destination")
public class Destination {

    @Id
    private String id;
    private String name;
    private String slug;
    private String parentSlug;
}
