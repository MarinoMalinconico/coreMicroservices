package com.companyName.coreMicroservices.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="invoices")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    @Setter
    private Long id;

    @Column(name="TRANSACTION_DATE")
    @Getter @Setter
    private LocalDate transaction_date; //YYYY-mm-dd 2025-09-30

    @Column(name="TRANSACTION_DESCRIPTION")
    @Getter @Setter
    private String transaction_description;

    @Column(name="FK_USER")
    @Getter @Setter
    private String fkUser;

    @Column(name="AMOUNT")
    @Getter @Setter
    private BigDecimal amount;

    @Column(name="CURRENCY")
    @Getter @Setter
    private String currency;

    public Invoice(Invoice invoice) { //serve a fare new Invoice(invoice), altrimenti devi fare new Invoice(invoice.getId,invoice.getName,....)
        this.id = invoice.getId();
        this.transaction_date = invoice.getTransaction_date();
        this.transaction_description = invoice.getTransaction_description();
        this.fkUser = invoice.getFkUser();
        this.amount = invoice.getAmount();
        this.currency = invoice.getCurrency();
    }
}