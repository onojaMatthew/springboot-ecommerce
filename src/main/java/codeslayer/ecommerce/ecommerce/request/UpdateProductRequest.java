package codeslayer.ecommerce.ecommerce.request;

import codeslayer.ecommerce.ecommerce.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
//Class 'ProductService' must either be declared abstract or implement abstract method 'updateProduct(Product)' in 'ProductInt'
@Data
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;
    private String brand;
    private Category category;
}
