package jsf.shop;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AddProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Product product;

	@Inject @ProductServiceAnotation
	private ProductsInterface productService;
	
	@PostConstruct
	public void init() {
		product = new Product();
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String add() {
		productService.addProduct(product);
		
		return "index?faces-redirect=true";
	}
}
