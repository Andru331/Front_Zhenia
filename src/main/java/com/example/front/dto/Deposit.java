package com.example.front.dto;

import java.math.BigDecimal;

public class Deposit {
    private String clienName;
    private String depoOpenDate;
    private String depoCloseDate;
    private String type;
    private BigDecimal balance;
    private String depoCode;

    public String getClienName() {
        return clienName;
    }

    public void setClienName(String clienName) {
        this.clienName = clienName;
    }

    public String getDepoOpenDate() {
        return depoOpenDate;
    }

    public void setDepoOpenDate(String depoOpenDate) {
        this.depoOpenDate = depoOpenDate;
    }

    public String getDepoCloseDate() {
        return depoCloseDate;
    }

    public void setDepoCloseDate(String depoCloseDate) {
        this.depoCloseDate = depoCloseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getDepoCode() {
        return depoCode;
    }

    public void setDepoCode(String depoCode) {
        this.depoCode = depoCode;
    }
}
