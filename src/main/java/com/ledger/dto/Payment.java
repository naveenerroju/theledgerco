package com.ledger.dto;

public class Payment {
    private String bankName;
    private String borrowerName;
    private long lumpSumAmount;
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

    public long getLumpSumAmount() {
        return lumpSumAmount;
    }

    public void setLumpSumAmount(long lumpSumAmount) {
        this.lumpSumAmount = lumpSumAmount;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }

    public Payment(String bankName, String borrowerName, long lumpSumAmount, int emiNumber) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.lumpSumAmount = lumpSumAmount;
        this.emiNumber = emiNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", lumpSumAmount=" + lumpSumAmount +
                ", EMINumber='" + emiNumber + '\'' +
                '}';
    }
}
