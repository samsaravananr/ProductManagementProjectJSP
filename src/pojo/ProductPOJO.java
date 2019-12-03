package pojo;

public class ProductPOJO 
{

	String productID;
	String productName;
	String productCategory;
	Integer productPrice;
	
	public ProductPOJO() 
	{
	
		// TODO Auto-generated constructor stub
	}

	public ProductPOJO(String productID, String productName, String productCategory, Integer productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductPOJO [productID=" + productID + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + "]";
	}

		
}
