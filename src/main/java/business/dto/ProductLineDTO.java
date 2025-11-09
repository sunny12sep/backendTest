package business.dto;

public class ProductLineDTO {
    private String productLine;
    private String textDescription;

    public ProductLineDTO(String productLine, String textDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
    }

    public String getProductLine() {
        return productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }
}