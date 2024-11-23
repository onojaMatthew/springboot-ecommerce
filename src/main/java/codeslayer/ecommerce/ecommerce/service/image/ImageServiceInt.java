package codeslayer.ecommerce.ecommerce.service.image;

import codeslayer.ecommerce.ecommerce.dto.ImageDto;
import codeslayer.ecommerce.ecommerce.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageServiceInt {
    Image getImageById(Long id);
    List<ImageDto> savedImages(List<MultipartFile> files, Long productId);
    void deleteImageById(Long id);
    void updateImage(MultipartFile file, Long imageId);
}
