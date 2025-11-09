package business.entity;

import java.io.Serializable;

public class OrderDetailId implements Serializable {
    private Integer orderNumber;
    private String productCode;
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
    
}