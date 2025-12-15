package com.companyName.coreMicroservices.repository;

import com.companyName.coreMicroservices.repository.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    /* DEPRECATO
    @Query(value="SELECT * FROM invoices WHERE INVOICE_NUMBER=:invoice_number", nativeQuery = true)
    List<Invoice> getAllInvoicePerUser(@Param("invoice_number")Long invoice_number);*/

    List<Invoice> findByinvoiceNumber(@Param("invoice_number")Long invoice_number);

    List<Invoice> findAll();

}
