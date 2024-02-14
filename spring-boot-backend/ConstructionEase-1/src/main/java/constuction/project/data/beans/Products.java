package constuction.project.data.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String category;
	private String name;
	private String description;
	private double price;
	private String ImagePath;
	
	private Long contractorId;
	
	


	public Products() {
		super();
	}




	public Products(long id, String categoty, String name, String description, double price, String imagePath,
			Long contractorId) {
		super();
		this.id = id;
		this.category = categoty;
		this.name = name;
		this.description = description;
		this.price = price;
		ImagePath = imagePath;
		this.contractorId = contractorId;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String categoty) {
		this.category = categoty;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public String getImagePath() {
		return ImagePath;
	}




	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}




	public Long getContractorId() {
		return contractorId;
	}




	public void setContractorId(Long contractorId) {
		this.contractorId = contractorId;
	}




	@Override
	public String toString() {
		return "Products [id=" + id + ", categoty=" + category + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", ImagePath=" + ImagePath + ", contractorId=" + contractorId + "]";
	}
	
	


	
	
	
	

}
