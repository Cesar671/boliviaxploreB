package com.movil.boliviaXplore.services;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.util.Map;
import java.util.Objects;

@Service
public class CloudinaryServiceImplement implements CloudinaryService {
    private final Cloudinary cloundinary;

    public CloudinaryServiceImplement(){
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("cloud_name", "dgr3g2a0g");
        valueMap.put("api_key", "121281624799425");
        valueMap.put("api_secret", "m7XSuad5rltu-nFzeBWwp8OoazA");
        cloundinary = new Cloudinary(valueMap);
    }

    @Override
    public Map upload(MultipartFile multipartFile){
        try{
        File file = convert(multipartFile);
        System.out.println("antes de entrar 12");
        Map result = this.cloundinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
        System.out.println("antes de entrar 13");
        if (!Files.deleteIfExists(file.toPath())) {
            System.out.println("antes de entrar 14");
            throw new IOException("Failed to delete temporary file");
        }
        System.out.println("antes de entrar 15");
        return result;
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return ObjectUtils.emptyMap();
    }

    @Override
    public Map delete(String id) throws IOException{
        return this.cloundinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

    public File convert(MultipartFile multipartFile) throws IOException{
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try(FileOutputStream fo = new FileOutputStream(file)){
            fo.close();
        }
        return file;
    }
}
