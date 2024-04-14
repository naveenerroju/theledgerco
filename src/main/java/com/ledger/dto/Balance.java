package com.ledger.dto;

public class Balance {
    private String bankName;
    private String borrowerName;
    private int emiNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }

    public Balance(String bankName, String borrowerName, int emiNumber) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.emiNumber = emiNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", EMINumber='" + emiNumber + '\'' +
                '}';
    }
}
