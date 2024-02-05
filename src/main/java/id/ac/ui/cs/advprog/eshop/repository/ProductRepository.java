package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product get(String id) {
        return productData.stream()
                .filter(t -> t.getProductId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product delete(String id) {
        Product product = get(id);
        productData.remove(product);
        return product;
    }
}