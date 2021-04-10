package com.tripaneer.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class Category {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String slug;

    public Category(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

}
