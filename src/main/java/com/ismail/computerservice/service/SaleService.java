package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateProductDto;
import com.ismail.computerservice.dto.CreateSaleDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Sale;
import com.ismail.computerservice.repository.ProductRepository;
import com.ismail.computerservice.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final ProductService productService;

    @Autowired
    public SaleService(ProductRepository productRepository, SaleRepository saleRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.productService = productService;
    }



    public Sale createSale(CreateSaleDto createSaleDto) {

        try {
            Sale sale = new Sale();
            sale.setNote(createSaleDto.getNote());
            sale.setPrice(createSaleDto.getPrice());

            Product product = productService.getProductByName(createSaleDto.getProductName());

            if (product != null) {
                sale.setProduct(product);
                return saleRepository.save(sale);
            } else {
                throw new RuntimeException("Ürün bulunamadı");
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create sale: ",e);
        }
    }



}
