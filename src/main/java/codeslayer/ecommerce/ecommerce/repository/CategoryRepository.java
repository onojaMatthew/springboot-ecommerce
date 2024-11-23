package codeslayer.ecommerce.ecommerce.repository;

import codeslayer.ecommerce.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName (String name);
    boolean existsByName(String name);
}
