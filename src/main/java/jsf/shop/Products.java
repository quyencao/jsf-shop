package jsf.shop;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("products")
@RequestScoped
public class Products {
	
	@Inject @ProductServiceAnotation
	private ProductsInterface productService;
	
	private List<Product> products;
	
	@PostConstruct
	public void init() {
		products = productService.getProducts();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
