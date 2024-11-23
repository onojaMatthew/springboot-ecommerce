package codeslayer.ecommerce.ecommerce.service.product;

import codeslayer.ecommerce.ecommerce.model.Product;
import codeslayer.ecommerce.ecommerce.request.AddProductRequest;
import codeslayer.ecommerce.ecommerce.request.UpdateProductRequest;

import java.util.List;

public interface ProductInt {
    Product addProduct(AddProductRequest product);
    Product getProduct(Long id);
    void deleteProductById(Long id);
    Product updateProduct(UpdateProductRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByBrandAndCategory(String brand, String category);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
