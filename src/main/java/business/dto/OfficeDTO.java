package business.dto;

public class OfficeDTO {
    private String officeCode;
    private String city;
    private String addressLine1;
    private String postalCode;

    public OfficeDTO(String officeCode, String city, String addressLine1, String postalCode) {
        this.officeCode = officeCode;
        this.city = city;
        this.addressLine1 = addressLine1;
        this.postalCode = postalCode;
    }

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}