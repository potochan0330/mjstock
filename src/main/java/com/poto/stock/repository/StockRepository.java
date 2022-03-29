package com.poto.stock.repository;

import com.poto.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findById(String id);
    List<Stock> findByCode(String code);
    List<Stock> findAll();
    Stock getByCode(String code);

    @Transactional
    @Modifying
    @Query("update Stock s set s.latest_price = :price where s.code = :code")
    void updatePrice(@Param(value = "code") String code, @Param(value = "price") Double price);
}
