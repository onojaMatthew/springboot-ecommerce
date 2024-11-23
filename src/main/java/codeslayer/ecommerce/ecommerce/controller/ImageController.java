package codeslayer.ecommerce.ecommerce.controller;

import codeslayer.ecommerce.ecommerce.dto.ImageDto;
import codeslayer.ecommerce.ecommerce.response.ApiResponse;
import codeslayer.ecommerce.ecommerce.service.image.ImageServiceInt;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/images")
public class ImageController {
    private final ImageServiceInt imageService;

    public ResponseEntity<ApiResponse> saveImages(@RequestBody List<MultipartFile> files, @RequestBody Long productId) {
        try {
            List<ImageDto> imageDtos = imageService.savedImages(files, productId);
            return ResponseEntity.ok(new ApiResponse("Upload success!", imageDtos)) ;
        } catch (Exception e) {
            return new  ResponseEntity.status(INT).bod
        }

    }

}
