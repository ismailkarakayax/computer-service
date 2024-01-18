package com.ismail.computerservice.service;

import com.ismail.computerservice.dto.CreateSaleLogDto;
import com.ismail.computerservice.model.Sale;
import com.ismail.computerservice.model.SaleLog;
import com.ismail.computerservice.model.User;
import com.ismail.computerservice.repository.SaleLogRepository;
import com.ismail.computerservice.repository.SaleRepository;
import com.ismail.computerservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SaleLogService {

    private final SaleLogRepository saleLogRepository;
    private final SaleRepository saleRepository;
    private final UserRepository userRepository;

    public SaleLogService(SaleLogRepository saleLogRepository, SaleRepository saleRepository, UserRepository userRepository) {
        this.saleLogRepository = saleLogRepository;
        this.saleRepository = saleRepository;
        this.userRepository = userRepository;
    }

    public SaleLog createSaleLog(CreateSaleLogDto createSaleLogDto) {
        try {
            Sale sale = createSaleEntity(createSaleLogDto);
            User user = createUserEntity(createSaleLogDto);
            // SaleLog'u kaydet
            SaleLog saleLog = createSaleLogEntity(createSaleLogDto, sale, user);
            
            deleteSaleAfterSaleLog(createSaleLogDto);

            return saleLog;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create saleLog: ",e);
        }
    }

    private SaleLog createSaleLogEntity(CreateSaleLogDto createSaleLogDto, Sale sale, User user) {
        LocalDateTime purchaseDate = LocalDateTime.now();
        SaleLog saleLog = new SaleLog();
        saleLog.setCreditCard(createSaleLogDto.getCreditCard());
        saleLog.setSale(sale);
        saleLog.setUser(user);
        saleLog.setDate(purchaseDate);
        return saleLog;
    }

    private Sale createSaleEntity(CreateSaleLogDto createSaleLogDto) {
        return saleRepository.findById(createSaleLogDto.getSaleId())
                .orElseThrow(() -> new RuntimeException("Satış bulunamadı"));

    }

    private User createUserEntity(CreateSaleLogDto createSaleLogDto) {
        return userRepository.findById(createSaleLogDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
    }

    private void deleteSaleAfterSaleLog(CreateSaleLogDto createSaleLogDto) {
        saleRepository.deleteById(createSaleLogDto.getSaleId());


    }
}
