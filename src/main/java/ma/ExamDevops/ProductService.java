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
	public void updateProduct(Product newProduct) {
		if(productExist(newProduct.getId())) {
			for (Product product : products) {
				if(product.getId() == newProduct.getId()) {
					product.setNom(newProduct.getNom());
					product.setPrix(newProduct.getPrix());
					product.setQuantite(newProduct.getQuantite());
				}
			}
		}
		else {
			System.out.println("le produit que vous voulez modifiez n'existe pas !");
		}
		
	}
	public void deleteProduct(long id) {
		for (Product product : products) {
			if(product.getId() == id) {
				products.remove(product);
				return;
			}
		}
		System.out.println("Le produit que vous voulez supprimez n'existe pas");
		
	}
	public void listProduct() {
		for (Product product : products) {
			System.out.println("Id : " + product.getId() + " nom : " + product.getNom() + " prix : " + product.getPrix() + " qté : " + product.getQuantite());
		}
	}
}
