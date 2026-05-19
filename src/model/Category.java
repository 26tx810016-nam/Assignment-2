package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Product> products; 

    // Constructor
    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>(); // Initialize the empty list
    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.setCategory(this);
    }

    public boolean removeProduct(Product product) {
        return this.products.remove(product);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public String getCategoryName() {
        return categoryName;
    }
}