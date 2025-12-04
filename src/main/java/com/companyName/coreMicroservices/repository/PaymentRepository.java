package com.companyName.coreMicroservices.repository;

import com.companyName.coreMicroservices.repository.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value="SELECT * FROM payments WHERE FK_USER=:FkUser", nativeQuery = true)
    List<Payment> getAllPaymentPerUser(@Param("FkUser")String FkUser);

    List<Payment> findByfkUser(@Param("FkUser")String FkUser);

    List<Payment> findAll();

}
