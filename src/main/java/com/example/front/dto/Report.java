package com.example.front.dto;

import java.math.BigDecimal;

public class Report {
    private String depoCode;
    private String clientPassport;
    private String depositType;
    private String openDate;
    private String closeDate;
    private BigDecimal balance;
    private BigDecimal totalAccrued;
    private BigDecimal totalTransactions;

    public String getDepoCode() {
        return depoCode;
    }

    public void setDepoCode(String depoCode) {
        this.depoCode = depoCode;
    }

    public String getClientPassport() {
        return clientPassport;
    }

    public void setClientPassport(String clientPassport) {
        this.clientPassport = clientPassport;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTotalAccrued() {
        return totalAccrued;
    }

    public void setTotalAccrued(BigDecimal totalAccrued) {
        this.totalAccrued = totalAccrued;
    }

    public BigDecimal getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(BigDecimal totalTransactions) {
        this.totalTransactions = totalTransactions;
    }
}
