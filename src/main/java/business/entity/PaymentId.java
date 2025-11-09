package business.entity;

import java.io.Serializable;

public class PaymentId implements Serializable {
    private Integer customerNumber;
    private String checkNumber;
	public Integer getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
}