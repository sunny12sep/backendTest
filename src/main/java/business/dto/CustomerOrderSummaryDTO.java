package business.dto;

public class CustomerOrderSummaryDTO {
    private Integer customerNumber;
    private String customerName;
    private Long numberOfOrders;

    public CustomerOrderSummaryDTO(Integer customerNumber, String customerName, Long numberOfOrders) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.numberOfOrders = numberOfOrders;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Long getNumberOfOrders() {
        return numberOfOrders;
    }
}