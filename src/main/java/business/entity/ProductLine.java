package business.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    private String productLine;

    private String textDescription;

    @Lob
    private String htmlDescription;

    @Lob
    private byte[] image;
    
    @OneToMany(mappedBy = "productLine")
    private List<Product> products;

    
	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
    
}