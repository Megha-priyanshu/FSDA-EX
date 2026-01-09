package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class App {
    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        dao.saveProduct(new Product("Apple Powder", "Dehydrated apples", 250, 50));
        dao.saveProduct(new Product("Tomato Powder", "Organic tomatoes", 180, 40));

        Product p = dao.getProduct(1L);
        if (p != null)
            System.out.println("Fetched: " + p.getName());

        dao.updateProduct(1L, 275, 60);
        dao.deleteProduct(2L);
    }
}
