package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @InjectMocks
    ProductController productController;

    @BeforeEach
    void setUp(){
    }

    @Test
    void productListPageTest() throws Exception {
        mvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList"));
    }

    @Test
    void createProductPageTest() throws Exception {
        mvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateProduct"));
    }

    @Test
    void createProductTest() throws Exception
    {
        Product product = new Product("1", "Ultraviolence album", 100);

        when(service.create(product)).thenReturn(product);

        System.out.println("ini print: " + product);

        mvc.perform(post("/product/create")
                        .flashAttr("product", product))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("list"));

        verify(service, times(1)).create(product);
    }

    @Test
    void editProductTest() throws Exception {
        Product product = new Product("1", "Ultraviolence album", 100);

        when(service.get("1")).thenReturn(product);
        when(service.edit(eq("1"), any(Product.class))).thenReturn(new Product("1", "Updated Album", 200));

        mvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditProduct"));

        mvc.perform(put("/product/edit/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"name\":\"Updated Album\",\"quantity\":200}"))
                .andExpect(status().isOk());

        verify(service, times(1)).edit(eq("1"), any(Product.class));
    }

    @Test
    void deleteProductTest() throws Exception {
        Product product = new Product("1", "Ultraviolence album", 100);

        when(service.get("1")).thenReturn(product); // Mock the service to return the product

        mvc.perform(delete("/product/delete/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Product deleted successfully")); // Check if the response message is as expected

        verify(service, times(1)).delete("1");
    }
}