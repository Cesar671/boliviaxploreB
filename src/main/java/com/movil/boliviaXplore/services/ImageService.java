package com.movil.boliviaXplore.services;

import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Image;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image uploadImage(MultipartFile file, Event event) throws IOException;
    void deleteImage(Image image) throws IOException;
}
