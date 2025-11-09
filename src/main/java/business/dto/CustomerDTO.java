package business.dto;

public class CustomerDTO {
    private Integer customerNumber;
    private String customerName;
    private String country;

    public CustomerDTO(Integer customerNumber, String customerName, String country) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.country = country;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCountry() {
        return country;
    }
}