package com.ismail.computerservice.controller;

import com.ismail.computerservice.dto.CreateRepairDto;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repair")
public class RepairController {

    private final RepairService repairService;


    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @GetMapping
    public ResponseEntity<List<Repair>> getAllRepairs() {
        return ResponseEntity.ok(repairService.getAllRepairs());
    }


}
