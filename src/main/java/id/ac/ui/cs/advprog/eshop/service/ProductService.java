package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
<<<<<<< HEAD
    public Product get(String id);
    public Product delete(String id);
=======
    public Product getProduct(String id);
    public Product edit(String id, Product product);
>>>>>>> 0ee169afb2eace0a592d6ae21da5a54bdc882dcc
}