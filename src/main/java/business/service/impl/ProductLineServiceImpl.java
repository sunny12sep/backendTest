package business.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import business.dto.ProductLineDTO;
import business.entity.Product;
import business.entity.ProductLine;
import business.exception.InvalidProductCodeException;
import business.repository.ProductLineRepository;
import business.repository.ProductRepository;
import business.service.ProductLineService;

@Service
public class ProductLineServiceImpl implements ProductLineService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductLineRepository productLineRepository;


    @Override
    public ProductLineDTO getProductLineSummaryByProductCode(String productCode) {
        ProductLine productLine = productRepository.findByProductCode(productCode)
                .map(Product::getProductLine)
                .orElseThrow(InvalidProductCodeException::new);

        return new ProductLineDTO(productLine.getProductLine(), productLine.getTextDescription());
    }
    
    @Override
    public List<ProductLineDTO> getAllProductLines() {
        List<ProductLine> productLines = productLineRepository.findAll();
        return productLines.stream()
                .map(pl -> new ProductLineDTO(pl.getProductLine(), pl.getTextDescription()))
                .collect(Collectors.toList());
    }

}