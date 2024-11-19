package com.movil.boliviaXplore.DTO;

import com.movil.boliviaXplore.models.Image;

public class ImageDTO {
    private Long codImagen;
    private String nameImage;
    private String urlImagen;
    private String imageId;

    public ImageDTO(Long codImage, String nameImage, String urlImage, String imageID){
        this.codImagen = codImage;
        this.nameImage = nameImage;
        this.urlImagen = urlImage;
        this.imageId = imageID;
    }

    public void setCodImagen(Long codImagen){
        this.codImagen = codImagen;
    }

    public Long getCodImagen(){
        return this.codImagen;
    }

    public void setNameImage(String nameImage){
        this.nameImage = nameImage;
    }

    public String getNameImage(){
        return this.nameImage;
    }

    public void setUrlImagen(String urlImagen){
        this.urlImagen = urlImagen;
    }

    public String getUrlImagen(){
        return this.urlImagen;
    }

    public void setImageId(String imageId){
        this.imageId = imageId;
    }

    public String getImageId(){
        return this.imageId;
    }


    public static ImageDTO getInstance(Image imagen){
        return new ImageDTO(imagen.getCodImagen(), imagen.getNameImage(), imagen.getUrlImagen(), imagen.getImageId());
    }
}
