package com.tripaneer.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "listing")
public class Listing {

    @Id
    private String id;

    private String title;

    @Indexed(unique = true)
    private String slug;

    @Field(name = "price_euro")
    private Double priceEuro;

    @Field(name = "tagged_categories")
    private List<String> taggedCategories;

    @Field(name = "tagged_destinations")
    private List<String> taggedDestinations;

    public Listing(String title, String slug, Double priceEuro, List<String> taggedCategories, List<String> taggedDestinations) {
        this.title = title;
        this.slug = slug;
        this.priceEuro = priceEuro;
        this.taggedCategories = taggedCategories;
        this.taggedDestinations = taggedDestinations;
    }
}
