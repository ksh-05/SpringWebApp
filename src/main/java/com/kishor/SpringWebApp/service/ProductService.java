package com.kishor.SpringWebApp.service;

import com.kishor.SpringWebApp.model.Product;
import com.kishor.SpringWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

//    List<Product> productList = new ArrayList<>(List.of(new Product(1, "Laptop", 20000.0F, "Asus Laptop"),
//                                        new Product(2, "Kindle", 2000.1F, "Amazon Kindle"),
//                                        new Product(3, "PowerBank", 107.1F, "Power Bank")));

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductById(int id){
//        return productList.stream().filter(product -> product.getId() == id).toList();
        return productRepo.findAllById(Collections.singleton(id));
    }

    public String addProduct(Product product){
//        productList.add(product);
        productRepo.save(product);
        return "Product added Successfully";
    }
    public String updateProduct(Product product){
//        Product data  = productList.stream().filter(p -> p.getId() == product.getId()).findFirst().get();
//        data.setId(product.getId());
//        data.setName(product.getName());
//        data.setPrice(product.getPrice());
//        data.setDescription(product.getDescription());
        productRepo.save(product);
        return "Update Successful";
    }
    public String deleteProduct(int id){
//        Product data  = productList.stream().filter(product -> product.getId() == id).findFirst().get();
//        productList.remove(data);
        productRepo.deleteById(id);
        return "product deleted";
    }
}
