package business.dto;

public class ProductVendorDTO {
	
	private String productVendor;
	private Short quantityInStock;
	
	public ProductVendorDTO(String productVendor, Short quantityInStock) {
		this.productVendor = productVendor;
		this.quantityInStock = quantityInStock;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public Short getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Short quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
}