package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    public Product get(String id);
    public Product delete(String id);
    public Product edit(String id, Product product);
}
