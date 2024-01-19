package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateProductDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductByName(String productName) {
        return productRepository.findByName(productName);
    }

    @Transactional
    public Product createProduct(CreateProductDto createProductDto) {
        try {
            Product product = new Product();
            product.setName(createProductDto.getName());
            return productRepository.save(product);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create product: ",e);
        }
    }

    public List<Product> getAllProducts() {
       try {
           return productRepository.findAll();
       }
       catch (Exception e) {
           throw new RuntimeException("Failed to get all products: ",e);
       }
    }

    public Product getProductById(Long id) {
        try {
            return productRepository.findById(id).get();
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to get product by id: ",e);
        }
    }
}
