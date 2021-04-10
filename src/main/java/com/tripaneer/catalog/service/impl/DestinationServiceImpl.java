package com.tripaneer.catalog.service.impl;

import com.tripaneer.catalog.service.DestinationService;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.util.Collections;
import java.util.List;

@Service
public class DestinationServiceImpl implements DestinationService {
    @Override
    public List<Destination> getTopDestination() {
        return Collections.emptyList();
    }
}
