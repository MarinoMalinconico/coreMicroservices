package com.companyName.coreMicroservices.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

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

    public Payment(Payment payment) { //costruttore, serve a fare new Payment(payment), altrimenti devi fare new Payment(payment.getId,payment.getName,....)
        this.id = payment.getId();
        this.transaction_date = payment.getTransaction_date();
        this.transaction_description = payment.getTransaction_description();
        this.fkUser = payment.getFkUser();
        this.amount = payment.getAmount();
        this.currency = payment.getCurrency();
    }

    //permette di aggiornare solo gli attibuti valorizzati(diversamente dal costruttore dove possono esserci anche null)
    public void updatePayment(Payment payment) { //serve a fare new Payment(payment), altrimenti devi fare new Payment(payment.getId,payment.getName,....)
        if (payment.getId() != null) {
            this.id = payment.getId();
        }
        if (payment.getTransaction_date() != null) {
            this.transaction_date = payment.getTransaction_date();
        }
        if (payment.getTransaction_description() != null) {
            this.transaction_description = payment.getTransaction_description();
        }
        if (payment.getFkUser() != null) {
            this.fkUser = payment.getFkUser();
        }
        if (payment.getAmount() != null) {
            this.amount = payment.getAmount();
        }
        if (payment.getCurrency() != null) {
            this.currency = payment.getCurrency();
        }
    }
}