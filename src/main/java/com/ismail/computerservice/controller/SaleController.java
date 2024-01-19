package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateProductDto;
import com.ismail.computerservice.dto.CreateSaleDto;
import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Sale;
import com.ismail.computerservice.service.ProductService;
import com.ismail.computerservice.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllSales")
    public ResponseEntity<List<Sale>> getAllSales() {
        try {
            List<Sale> sales = saleService.getAllSales();
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSalesByProductId/{id}")
    public ResponseEntity<List<Sale>> getSaleByProductId(@PathVariable Long id) {
        try {
            List<Sale> sales = saleService.getSalesByProductId(id);
            return new ResponseEntity<>(sales, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSaleById/{id}")
    public ResponseEntity<Sale> deleteSaleById(@PathVariable Long id) {
        try {
            Sale sale = saleService.deleteSaleById(id);
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
