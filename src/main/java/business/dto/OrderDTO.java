package business.dto;

import java.sql.Date;

public class OrderDTO {
    private Integer orderNumber;
    private Date orderDate;
    private String status;
    private Date shippedDate;
    private String customerName;
    
    public OrderDTO(Integer orderNumber, Date orderDate, Date shippedDate, String status, String customerName) {
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.status = status;
		this.shippedDate = shippedDate;
		this.customerName = customerName;
	}

	public Integer getOrderNumber() {
        return orderNumber;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

	public Date getShippedDate() {
		return shippedDate;
	}
	
	public String getCustomerName() {
        return customerName;
    }
}