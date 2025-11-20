package com.companyName.coreMicroservices.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name="INVOICE_NUMBER")
    @Getter @Setter
    private Long invoiceNumber;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "payment_id") // foreign key in payments table
    @Getter @Setter
    private List<Payment> payments = new ArrayList<>();


    public Invoice(Invoice invoice) { //serve a fare new Invoice(invoice), altrimenti devi fare new Invoice(invoice.getId,invoice.getName,....)
        this.id = invoice.getId();
        this.invoiceNumber = invoice.getInvoiceNumber();
        this.payments = invoice.getPayments();
        //for (Payment payment: invoice.payments)
        //{
        //    this.payments.add(payment);
        //}
    }
}