package business.dto;

public class EmployeeCustomerCountDTO {
    private Integer employeeNumber;
    private String firstName;
    private String lastName;
    private Long customerCount;

    public EmployeeCustomerCountDTO(Integer employeeNumber, String firstName, String lastName, Long customerCount) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerCount = customerCount;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getCustomerCount() {
        return customerCount;
    }
}