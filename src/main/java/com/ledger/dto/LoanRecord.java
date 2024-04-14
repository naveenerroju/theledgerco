package com.ledger.dto;

public class LoanRecord {
    private String bankName;
    private String borrowerName;
    private long principle;
    private long totalLumpSumPaid;
    private long totalPayOffAmount;
    private int interest;
    private int tenure;
    private long balance;
    private int emiNumber;
    private int emi;

    public LoanRecord() {
        // initialise a record
    }

    public long getTotalLumpSumPaid() {
        return totalLumpSumPaid;
    }

    public void setTotalLumpSumPaid(long totalLumpSumPaid) {
        this.totalLumpSumPaid = totalLumpSumPaid;
    }

    public int getEmi() {
        return emi;
    }

    public long getTotalPayOffAmount() {
        return totalPayOffAmount;
    }

    public void setTotalPayOffAmount(long totalPayOffAmount) {
        this.totalPayOffAmount = totalPayOffAmount;
    }

    public void setEmi(int emi) {
        this.emi = emi;
    }

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

    public long getPrinciple() {
        return principle;
    }

    public void setPrinciple(long principle) {
        this.principle = principle;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public int getEmiNumber() {
        return emiNumber;
    }

    public void setEmiNumber(int emiNumber) {
        this.emiNumber = emiNumber;
    }

    @Override
    public String toString() {
        return "LoanRecords{" +
                "bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", principle=" + principle +
                ", interest=" + interest +
                ", tenure=" + tenure +
                ", balance=" + balance +
                ", emi=" + emiNumber +
                '}';
    }
}
