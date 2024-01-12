package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateSaleLogDto;
import com.ismail.computerservice.model.SaleLog;
import com.ismail.computerservice.service.SaleLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/saleLog")
public class SaleLogController {

    private final SaleLogService saleLogService;


    public SaleLogController(SaleLogService saleLogService) {
        this.saleLogService = saleLogService;
    }

    @PostMapping("/create")
    public ResponseEntity<SaleLog> createSaleLog(@RequestBody CreateSaleLogDto createSaleLogDto) {
        SaleLog saleLog = saleLogService.createSaleLog(createSaleLogDto);
        return new ResponseEntity<>(saleLog, HttpStatus.CREATED);

    }
}
