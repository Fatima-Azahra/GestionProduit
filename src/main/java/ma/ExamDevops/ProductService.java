package ma.ExamDevops;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	private List<Product> products ;
	public ProductService () {
		this.products = new ArrayList<Product>();
	}
	public boolean productExist(Long id) {
		for (Product product : products) {
			if(product.getId() == id) {
				return false;
			}
		}
		return true;
	}
	public void AddProduct(Product product) {
		try {
		if(!productExist(product.getId())) {
			products.add(product);
		}
		}catch(Exception e) {
			System.out.println("Ce produit existe deja !");
		}
	}	
}
