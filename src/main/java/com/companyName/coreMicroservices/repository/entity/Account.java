package com.companyName.coreMicroservices.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    @Setter
    private Long id;


    @Column(name="NAME")
    @Getter @Setter
    private String name;

    @Column(name="SURNAME")
    @Getter @Setter
    private String surname;

    @Column(name="EMAIL")
    @Getter @Setter
    private String email;

    @Column(name="FK_USER")
    @Getter @Setter
    private String fkUser;

    @Column(name="BALANCE")
    @Getter @Setter
    private BigDecimal balance;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "account_id") // foreign key in payments table
    @Getter @Setter
    private List<Invoice> invoices = new ArrayList<>();

    public Account(Account account) { //costruttore, serve a fare new Account(account), altrimenti devi fare new Account(account.getId,account.getName,....)
        this.id = account.getId();
        this.name = account.getName();
        this.surname = account.getSurname();
        this.email = account.getEmail();
        this.fkUser = account.getFkUser();
        this.balance = account.getBalance();
        this.invoices = account.getInvoices();
    }

    //permette di aggiornare solo gli attibuti valorizzati(diversamente dal costruttore dove possono esserci anche null)
    public void updateAccount(Account account) { //serve a fare new Account(account), altrimenti devi fare new Account(account.getId,account.getName,....)
        if (account.getId() != null) {
            this.id = account.getId();
        }
        if (account.getName() != null) {
            this.name = account.getName();
        }
        if (account.getSurname() != null) {
            this.surname = account.getSurname();
        }
        if (account.getEmail() != null) {
            this.email = account.getEmail();
        }
        if (account.getFkUser() != null) {
            this.fkUser = account.getFkUser();
        }
        if (account.getBalance() != null) {
            this.balance = account.getBalance();
        }
        if (account.getInvoices() != null) {
            this.invoices = account.getInvoices();
        }
    }
}