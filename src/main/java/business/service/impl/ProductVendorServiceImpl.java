package business.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import business.dto.ProductVendorDTO;
import business.entity.Product;
import business.exception.InvalidProductCodeException;
import business.repository.ProductRepository;
import business.service.ProductVendorService;

@Service
public class ProductVendorServiceImpl implements ProductVendorService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductVendorDTO getProductVendorByProductCode(String productCode) {
        Optional<Product> product = productRepository.findByProductCode(productCode);
        if (product.isPresent() == false) {
            throw new InvalidProductCodeException();
        }
        return new ProductVendorDTO(product.get().getProductVendor(), product.get().getQuantityInStock());
    }
}