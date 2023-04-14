package kz.rakhimov.goodplaces.services;

import kz.rakhimov.goodplaces.entity.Place;

import java.util.List;

public interface PlaceService {
    Place addPlace(Place place);
    List<Place> getAllPlaces();
    Place getPlace(Long id);
}
