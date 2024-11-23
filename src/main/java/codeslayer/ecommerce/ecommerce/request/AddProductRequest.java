package codeslayer.ecommerce.ecommerce.request;

import codeslayer.ecommerce.ecommerce.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;
    private String brand;
    private Category category;
}
