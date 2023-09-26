package kz.bitlab.springsecuritytesting.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    boolean uploadFile(MultipartFile file, String email);
}
