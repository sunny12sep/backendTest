package business.dto;

public class EmployeeDTO {
    private Integer employeeNumber;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String email;
    private String officeCode;

    public EmployeeDTO(Integer employeeNumber, String firstName, String lastName, String jobTitle, String email,
			String officeCode) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
		this.email = email;
		this.officeCode = officeCode;
	}

	public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
		return email;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}