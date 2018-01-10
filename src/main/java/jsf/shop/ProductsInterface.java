package jsf.shop;

import java.util.List;

public interface ProductsInterface {
	public List<Product> getProducts();
	
	public Product getProduct(int id);
	
	public void addProduct(Product p);
}
