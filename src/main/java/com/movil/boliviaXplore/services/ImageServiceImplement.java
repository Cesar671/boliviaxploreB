package com.movil.boliviaXplore.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import com.movil.boliviaXplore.repository.ImageRepository;
import com.movil.boliviaXplore.models.Event;
import com.movil.boliviaXplore.models.Image;
import java.util.Map;

@Service
public class ImageServiceImplement implements ImageService {
    private final CloudinaryService cloudinaryService;
    private final ImageRepository imageRepository;

    public ImageServiceImplement(CloudinaryService cloudinaryService, ImageRepository imageRepository){
        this.cloudinaryService = cloudinaryService;
        this.imageRepository = imageRepository;
    }
   
    @Override
    public Image uploadImage(MultipartFile file, Event event) throws IOException{
        Map uploadResult = this.cloudinaryService.upload(file);
        String imageUrl = (String) uploadResult.get("url");
        String imageId = (String) uploadResult.get("public_id");
        Image image = new Image(file.getOriginalFilename(), imageUrl, imageId, event);
        return imageRepository.save(image);
    }

    @Transactional
    @Override
    public void deleteImage(Image image) throws IOException{
        this.cloudinaryService.delete(image.getImageId());
        this.imageRepository.delete(image);
    }
}
