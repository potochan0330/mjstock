package com.poto.stock.repository;

import com.poto.stock.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(String id);
    List<Customer> findAll();

    @Query("select c from Customer c where c.email like '%@gmail.com'")
    List<Customer> findUsersWithGmailAddress();

    @Transactional
    @Modifying
    @Query("update Customer c set c.first_name = :firstname where c.id = :id")
    void updateFirstname(@Param(value = "id") Integer id, @Param(value = "firstname") String firstname);
}
