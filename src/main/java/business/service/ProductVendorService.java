package business.service;

import business.dto.ProductVendorDTO;

public interface ProductVendorService {
	ProductVendorDTO getProductVendorByProductCode(String productCode);
}