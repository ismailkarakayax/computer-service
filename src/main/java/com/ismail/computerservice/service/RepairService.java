package com.ismail.computerservice.service;


import com.ismail.computerservice.dto.CreateRepairDto;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.repository.RepairRepository;
import com.ismail.computerservice.repository.RepairRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }


    public List<Repair> getAllRepairs(){
        return repairRepository.findAll();
    }

}
