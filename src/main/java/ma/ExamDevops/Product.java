package ma.ExamDevops;

public class Product {
	private Long id;
	private String nom;
	private double prix;
	private int quantite;
	public Product(Long id, String nom, double prix, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		try {
			if(prix > 0 ) {
				this.prix = prix;
			}
		}catch(Exception e) {
			System.out.println("le prix doit etre positive");
		}
		try {
			if(quantite > 0 ) {
				this.quantite = quantite;
			}
		}catch(Exception e) {
			System.out.println("la quantité doit etre positive");
		}
		}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		try {
			if(prix > 0) {
				this.prix = prix;
			}
		}catch(Exception e) {
			System.out.println("le nouveau prix doit etre positive !");
		}
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		try {
			if(quantite > 0 ) {
				this.quantite = quantite;
			}
		}catch(Exception e) {
			System.out.println("la quantité doit etre positive");
		}
	}
	public Long getId() {
		return id;
	}
	public static void main(String[] args) {
		
		Product p = new Product(null, null, -11, 0);
	}
	}
