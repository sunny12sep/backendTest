package business.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import business.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	Optional<Product> findByProductCode(String productCode);
	List<Product> findByProductLine_ProductLine(String productLine);
}