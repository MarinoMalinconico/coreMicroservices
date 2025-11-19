package com.companyName.coreMicroservices.repository;

import com.companyName.coreMicroservices.repository.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    @Query(value="SELECT * FROM invoices WHERE FK_USER=:FkUser", nativeQuery = true)
    List<Invoice> getAllInvoicePerUser(@Param("FkUser")String FkUser);

    List<Invoice> findByfkUser(@Param("FkUser")String FkUser);

    List<Invoice> findAll();

    @Query(value="DELETE FROM invoices WHERE FK_USER=:FkUser", nativeQuery = true)
    List<Invoice> deleteinvoiceByfkUser(@Param("FkUser")String FkUser);

}
