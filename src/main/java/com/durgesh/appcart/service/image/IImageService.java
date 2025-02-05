package com.durgesh.appcart.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.durgesh.appcart.dto.ImageDto;
import com.durgesh.appcart.model.Image;

public interface IImageService {

    Image getImageById(Long id);

    void deleteImageById(Long id);

    List<ImageDto> saveImage(List<MultipartFile> file, Long productId);

    void updateImage(MultipartFile file, Long imageId);

}
