package kz.rakhimov.goodplaces.services.impl;

import kz.rakhimov.goodplaces.entity.Place;
import kz.rakhimov.goodplaces.repositories.PlaceRepository;
import kz.rakhimov.goodplaces.services.FileService;
import kz.rakhimov.goodplaces.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private PlaceRepository placeRepository;
    @Override
    public boolean uploadPhoto(MultipartFile file, Long id) {
        try {
            byte bytes[] = file.getBytes();
            String fileName = "photo" + id;
            String filePath = "build/resources/main/static/" + fileName + ".jpg";
            Path path = (Paths.get(filePath));
            Files.write(path,bytes);
            Place place = placeRepository.findAllById(id);
            place.setPicture(fileName);
            placeRepository.save(place);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
