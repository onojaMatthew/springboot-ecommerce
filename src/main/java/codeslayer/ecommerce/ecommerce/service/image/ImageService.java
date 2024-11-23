package codeslayer.ecommerce.ecommerce.service.image;

import codeslayer.ecommerce.ecommerce.dto.ImageDto;
import codeslayer.ecommerce.ecommerce.exceptions.ResourceNotFoundException;
import codeslayer.ecommerce.ecommerce.model.Image;
import codeslayer.ecommerce.ecommerce.model.Product;
import codeslayer.ecommerce.ecommerce.repository.ImageRepository;
import codeslayer.ecommerce.ecommerce.service.product.ProductInt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService implements ImageServiceInt {
    private final ImageRepository imageRepository;
    private final ProductInt productService;
    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Image not found")
                );
    }

    @Override
    public List<ImageDto> savedImages(List<MultipartFile> files, Long productId) {
        Product product = productService.getProduct(productId);
        List<ImageDto> savedImageDto = new ArrayList<>();
        for (MultipartFile file: files) {
            try {
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setProduct(product);
                String buildDownloadUrl = "/api/images/image";
                String downloadUrl = buildDownloadUrl +image.getId();
                image.setDownloadUrl(downloadUrl);
                Image savedImage = imageRepository.save(image);
                savedImage.setDownloadUrl(buildDownloadUrl+savedImage.getId());
                imageRepository.save(savedImage);

                ImageDto imageDto = new ImageDto();
                imageDto.setImageId(savedImage.getId());
                imageDto.setImageName(savedImage.getFileName());
                imageDto.setDownloadUrl(savedImage.getDownloadUrl());
                savedImageDto.add(imageDto);
            } catch (Exception e) {
                new RuntimeException(e.getMessage());
            }
        }
        return savedImageDto;
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, ()-> {
            throw new ResourceNotFoundException("No image found with this id "+id);
        });
    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch(IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
