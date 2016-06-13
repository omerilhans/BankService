package com.bank.data.entity;

import com.bank.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private long accountId;
    @Column(name = "customerFullName")
    private String customerFullName;
    @Column(name = "accountType")
    private String accountType;
    @Column(name = "accountNumber")
    private long accountNumber;
    @Column(name = "nameOf_Bank")
    private String nameOf_Bank;
    @Column(name = "balanceCard")
    private int balanceCard;
    @Column(name = "limit_card")
    private int limit_card;

    //<editor-fold defaultstate="collapsed" desc="Getter - Setter">
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalanceCard() {
        return balanceCard;
    }

    public void setBalanceCard(int balanceCard) {
        this.balanceCard = balanceCard;
    }

    public int getLimit_card() {
        return limit_card;
    }

    public void setLimit_card(int limit_card) {
        this.limit_card = limit_card;
    }

    public String getNameOf_Bank() {
        return nameOf_Bank;
    }

    public void setNameOf_Bank(String nameOf_Bank) {
        this.nameOf_Bank = nameOf_Bank;
    }
//</editor-fold>

}
