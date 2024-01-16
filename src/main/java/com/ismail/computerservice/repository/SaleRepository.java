package com.ismail.computerservice.repository;

import com.ismail.computerservice.model.Product;
import com.ismail.computerservice.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByProductId(Long id);
}
