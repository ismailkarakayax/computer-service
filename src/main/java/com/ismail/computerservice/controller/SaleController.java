package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateProductDto;
import com.ismail.computerservice.dto.CreateSaleDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Sale;
import com.ismail.computerservice.service.ProductService;
import com.ismail.computerservice.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sale")
public class SaleController {

    private final SaleService saleService;


    public SaleController(SaleService saleService) {
        this.saleService = saleService;

    }


    @PostMapping("/createSale")
    public ResponseEntity<Sale> createSale(@RequestBody CreateSaleDto createSaleDto) {
        Sale sale = saleService.createSale(createSaleDto);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
    }

}
