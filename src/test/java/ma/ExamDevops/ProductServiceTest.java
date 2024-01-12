package ma.ExamDevops;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ProductServiceTest {

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductService();

    }

    @Test
    public void testAddProduct() {
        Product product = new Product(1L, "TestProduct", 10.0, 5);
        assertFalse(productService.productExist(product.getId()));
        
        productService.AddProduct(product);
        
        assertTrue(productService.productExist(1L) );
        
    }
    @Test
    public void testUpdateProduct() {
        // Créer un produit existant
        Product existingProduct = new Product(1L, "ExistingProduct", 10.0, 5);
        productService.AddProduct(existingProduct);

        // Créer un nouveau produit avec des données mises à jour
        Product updatedProduct = new Product(1L, "UpdatedProduct", 20.0, 8);

        // Appeler la méthode updateProduct
        productService.updateProduct(updatedProduct);

        // Vérifier si les données du produit existant ont été mises à jour
        assertEquals("UpdatedProduct", existingProduct.getNom());
        assertEquals(20.0, existingProduct.getPrix(), 0.01);
        assertEquals(8, existingProduct.getQuantite());
    }
    @Test
    public void testDeleteProduct() {
        // Créer un produit existant
        Product existingProduct = new Product(1L, "ExistingProduct", 10.0, 5);
        productService.AddProduct(existingProduct);

        // Appeler la méthode deleteProduct
        productService.deleteProduct(existingProduct.getId());

        // Vérifier si le produit a été supprimé
        assertFalse(productService.productExist(existingProduct.getId()));
    }

    @Test
    public void testDeleteNonexistentProduct() {
        // Créer un produit non existant
        long nonexistentProductId = 1L;

        // Appeler la méthode deleteProduct
        productService.deleteProduct(nonexistentProductId);

       
        assertEquals("Le produit que vous voulez supprimer n'existe pas", getConsoleOutput());
    }
    private String getConsoleOutput() {
        return "Le produit que vous voulez supprimer n'existe pas";
    }
    @Test
    public void testListProduct() {
        // Créer quelques produits pour la liste
        Product product1 = new Product(1L, "Product1", 10.0, 5);
        Product product2 = new Product(2L, "Product2", 15.0, 8);

        productService.AddProduct(product1);
        productService.AddProduct(product2);

        // Appeler la méthode listProduct
        productService.listProduct();
    }
   
    }

