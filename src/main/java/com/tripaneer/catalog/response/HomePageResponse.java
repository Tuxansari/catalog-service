package com.tripaneer.catalog.response;

import jdk.jfr.Category;
import lombok.Builder;
import lombok.Data;

import javax.print.attribute.standard.Destination;
import java.util.List;

@Data
@Builder
public class HomePageResponse {
    private List<Category> categoryList;
    private List<Destination> destinationList;

}
