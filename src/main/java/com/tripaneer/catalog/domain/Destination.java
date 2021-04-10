package com.tripaneer.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "destination")
public class Destination {

    @Id
    private String id;

    private String name;

    @Indexed(unique=true)
    private String slug;

    @Field(name = "parent_slug")
    private String parentSlug;

    public Destination(String name, String slug, String parentSlug) {
        this.name = name;
        this.slug = slug;
        this.parentSlug = parentSlug;
    }
}
