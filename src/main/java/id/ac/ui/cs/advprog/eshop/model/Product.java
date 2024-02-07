package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;

    public void setProductQuantity(int productQuantity) {
        if (productQuantity < 1) {
            throw new IllegalArgumentException("Product quantity must be positive integer");
        }
        this.productQuantity = productQuantity;
    }
}