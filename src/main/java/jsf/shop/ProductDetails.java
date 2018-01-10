package jsf.shop;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named("productDetails")
@RequestScoped
public class ProductDetails implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private Product product;
	
	@Inject @ProductServiceAnotation
	private ProductsInterface productService;
	
	@PostConstruct
	public void onload() {
		product = productService.getProduct(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
