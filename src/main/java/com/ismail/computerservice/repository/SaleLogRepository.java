package com.ismail.computerservice.repository;

import com.ismail.computerservice.model.SaleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleLogRepository extends JpaRepository<SaleLog, Long> {
}
