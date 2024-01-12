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
            Sale sale = saleRepository.findById(createSaleLogDto.getSaleId())
                    .orElseThrow(() -> new RuntimeException("Satış bulunamadı"));

            // Kullanıcıyı ID üzerinden bul
            User user = userRepository.findById(createSaleLogDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

            LocalDateTime purchaseDate = LocalDateTime.now();

            // Yeni SaleLog nesnesi oluştur
            SaleLog saleLog = new SaleLog();

            saleLog.setCreditCard(createSaleLogDto.getCreditCard());
            saleLog.setSale(sale);
            saleLog.setUser(user);
            saleLog.setDate(purchaseDate);

            // SaleLog'u kaydet
            return saleLogRepository.save(saleLog);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create saleLog: ",e);
        }
    }



}
