import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null; 
    }

    public void updateProduct(int id, String newName, double newPrice) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("newName must not be blank");
        }
        if (newPrice < 0) {
            throw new IllegalArgumentException("newPrice must be >= 0");
        }
        for (int i = 0; i < products.size(); i++) {
            Product current = products.get(i);
            if (current.getId() == id) {
                products.set(i, new Product(id, newName, newPrice));
                return;
            }
        }
        // Optionally, signal not-found (return boolean or throw)
        // throw new NoSuchElementException("No product with id " + id);
    }
    public void deleteProduct(int id) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getId() == id) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}