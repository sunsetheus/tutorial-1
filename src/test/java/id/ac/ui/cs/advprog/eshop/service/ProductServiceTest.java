package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void testCreateProduct() {
        Product product = new Product("l4n4-ul7r4", "Ultraviolence album", 100);

        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertEquals(product, createdProduct);
    }

    @Test
    void testFindAllProducts() {
        List<Product> products = new ArrayList<Product>();
        Product product1 = new Product("l4n4-artlu", "Ultraviolence album", 100);
        Product product2 = new Product("4ri4n4-teews", "Sweetener album", 200);
        products.add(product1);
        products.add(product2);

        when(productRepository.create(product1)).thenReturn(product1);
        when(productRepository.create(product2)).thenReturn(product2);
        when(productRepository.findAll()).thenReturn(products.iterator());

        productService.create(product1);
        productService.create(product2);

        List<Product> iterator = productService.findAll();
        assertEquals(2, products.size());
    }

    @Test
    void testGetProduct() {
        Product product = new Product("l4n4-artlu", "Ultraviolence album", 100);

        when(productRepository.create(product)).thenReturn(product);
        when(productRepository.get(product.getProductId())).thenReturn(product);

        productService.create(product);
        Product foundProduct = productService.get(product.getProductId());

        assertEquals(product, foundProduct);
    }

    @Test
    void testEditProduct() {
        Product product =  new Product("l4n4-artlu", "Ultraviolence album", 100);
        Product editedProduct = new Product("l4n4-artlu", "Born to Die album", 200);

        when(productService.create(product)).thenReturn(product);
        when(productService.edit(product.getProductId(), editedProduct)).thenReturn(editedProduct);
        when(productRepository.get(product.getProductId())).thenReturn(editedProduct);

        productService.create(product);
        productService.edit(product.getProductId(), editedProduct);
        Product foundProduct = productService.get(product.getProductId());

        assertEquals(editedProduct, foundProduct);
    }

    @Test
    void testDeleteProduct() {
        List<Product> products = new ArrayList<Product>();
        Product product =  new Product("l4n4-artlu", "Ultraviolence album", 100);
        products.add(product);

        when(productService.create(product)).thenReturn(product);
        when(productRepository.delete(product.getProductId())).then(invocation -> {
            products.removeIf(p -> p.getProductId().equals(product.getProductId()));
            return product;
        });
        when(productRepository.findAll()).thenReturn(products.iterator());

        productService.create(product);
        productService.delete(product.getProductId());
        List<Product> iterator = productService.findAll();

        assertEquals(0, products.size());
    }
}
