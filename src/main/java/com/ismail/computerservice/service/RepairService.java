package com.ismail.computerservice.service;


import com.ismail.computerservice.dto.CreateRepairDto;
import com.ismail.computerservice.model.Repair;
import com.ismail.computerservice.repository.RepairRepository;
import com.ismail.computerservice.repository.RepairRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }




    @Transactional
    public Repair createRepair(CreateRepairDto createRepairDto) {
        try {
            Repair Repair = new Repair();
            Repair.setDescription(createRepairDto.getDescription());
            Repair.setDuration(createRepairDto.getDuration());
            Repair.setLaptop(createRepairDto.getLaptop());
            Repair.setDesktop(createRepairDto.getDesktop());
            Repair.setMac(createRepairDto.getMac());
            return repairRepository.save(Repair);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to create Repair: ",e);
        }
    }
}
