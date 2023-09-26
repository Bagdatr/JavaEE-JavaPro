package kz.bitlab.springsecuritytesting.services.impl;

import kz.bitlab.springsecuritytesting.entities.Photo;
import kz.bitlab.springsecuritytesting.entities.Users;
import kz.bitlab.springsecuritytesting.repositories.PhotoRepository;
import kz.bitlab.springsecuritytesting.repositories.UsersRepository;
import kz.bitlab.springsecuritytesting.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean uploadFile(MultipartFile file, String email) {
        try {
            Users user = usersRepository.findByEmail(email);
            String fileName = email + user.getPhotos().size();
            String temp = passwordEncoder.encode(fileName);
            String fileFinalName = "";
            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i) != '/' && temp.charAt(i) != '.' && temp.charAt(i) != ',') {
                    fileFinalName = fileFinalName + temp.charAt(i);
                }
            }
            Photo photo = Photo.builder()
                    .name(fileFinalName)
                    .build();
            byte bytes[] = file.getBytes();
            Path path = Paths.get("build/resources/main/static/" + fileFinalName + ".jpg");
            Files.write(path, bytes);
            user.getPhotos().add(photo);
            photoRepository.save(photo);
            usersRepository.save(user);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
