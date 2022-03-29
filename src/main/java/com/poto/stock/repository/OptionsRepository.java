package com.poto.stock.repository;

import com.poto.stock.entity.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OptionsRepository extends JpaRepository<Options, Long> {

    List<Options> findById(String id);
    List<Options> findByType(Integer type);
    List<Options> findAll();

    @Transactional
    @Modifying
    @Query("update Options s set s.option_price = :price where s.code = :code")
    void updatePrice(@Param(value = "code") String code, @Param(value = "price") Double price);
}
