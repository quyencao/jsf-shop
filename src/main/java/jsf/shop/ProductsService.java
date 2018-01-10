package jsf.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ProductServiceAnotation
@ApplicationScoped
public class ProductsService implements ProductsInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Product> products;
	
	public ProductsService() {
		products = new ArrayList<Product>();
		products.add(new Product(1, "COUNTERPRINT by Karel Martens", "description", 200, "image"));
		products.add(new Product(2, "COUNTERPRINT by Karel Martens", "description", 140, "image"));
		products.add(new Product(3, "COUNTERPRINT by Karel Martens", "description", 250, "image"));
		products.add(new Product(4, "COUNTERPRINT by Karel Martens", "description", 300, "image"));
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct(int id) {
//		for(Product p: products) {
//			if(p.getId() == id) {
//				return p;
//			}
//		}
//		return null;
		Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
		
		if(product.isPresent()) {
			return product.get();
		} 
		
		return null;
	}
	
	public void addProduct(Product p) {
		int id = products.get(products.size() - 1).getId() + 1;
		p.setId(id);
		products.add(p);
	}
	
}
