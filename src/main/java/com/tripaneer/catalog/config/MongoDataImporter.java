package com.tripaneer.catalog.config;

import com.tripaneer.catalog.domain.Category;
import com.tripaneer.catalog.domain.Destination;
import com.tripaneer.catalog.domain.Listing;
import com.tripaneer.catalog.repository.CategoryRepository;
import com.tripaneer.catalog.repository.DestinationRepository;
import com.tripaneer.catalog.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class MongoDataImporter {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private ListingRepository listingRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void buildCategory() {
        System.out.println("Building Categories");
        try {
            categoryRepository.deleteAll();
            InputStream inputStream = MongoDataImporter.class.getResourceAsStream("/categories.csv");
            List<String> lines = readFromInputStream(inputStream);
            for (int i = 1 ; i < lines.size() ; i++) {
                String[] split = lines.get(i).split(",");
                String title = split[0];
                String slug = split[1];
                Category category = new Category(title, slug);
                categoryRepository.save(category);
            }
        } catch (Exception ex) {
        }

    }

    @EventListener(ApplicationReadyEvent.class)
    public void buildDestination() {
        System.out.println("Building Destinations");
        try {
            destinationRepository.deleteAll();
            InputStream inputStream = MongoDataImporter.class.getResourceAsStream("/destinations.csv");
            List<String> lines = readFromInputStream(inputStream);
            for (int i = 1 ; i < lines.size() ; i++) {
                String[] split = lines.get(i).split(",");
                String name = split[0];
                String slug = split[1];
                String parentSlug = null;
                if (split.length >= 3)
                    parentSlug = split[2];
                Destination destination = new Destination(name, slug, parentSlug);
                destinationRepository.save(destination);
            }
        } catch (Exception ex) {
        }

    }


    @EventListener(ApplicationReadyEvent.class)
    public void buildListing() {
        System.out.println("Building Listing");
        try {
            listingRepository.deleteAll();
            InputStream inputStream = MongoDataImporter.class.getResourceAsStream("/listing.csv");
            List<String> lines = readFromInputStream(inputStream);
            for (int i = 1; i < lines.size(); i++) {
                String[] split = lines.get(i).split(",");
                String title = split[0];
                String slug = split[1];
                Double priceEuro = Double.parseDouble(split[2]);
                List<String> catagoryList = Collections.singletonList(split[3]);
                List<String> destList = getDestList(split);
                Listing listing = new Listing(title, slug, priceEuro, catagoryList, destList);
                listingRepository.save(listing);
            }
        } catch (Exception ex) {
        }

    }

    private List<String> getDestList(String[] split) {
        List<String> destList = new ArrayList<>();
        for (int i = 4 ; i < split.length ; i++) {
            destList.add(split[i]);
        }
        return destList;
    }

    private List<String> readFromInputStream(InputStream inputStream)
            throws IOException {
        List<String> output = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                output.add(line);
            }
        }
        return output;
    }
}
