package com.ledger.dto;

public class LoanRecord {
    private String bankName;
    private String borrowerName;
    private long principle;
    private long totalLumpSumPaid;
    private double totalPayOffAmount;
    private int interest;
    private int tenure;
    private double balance;
    private int emiNumber;
    private double emi;

    public LoanRecord() {
        // initialise a record
    }

    public long getTotalLumpSumPaid() {
        return totalLumpSumPaid;
    }

    public void setTotalLumpSumPaid(long totalLumpSumPaid) {
        this.totalLumpSumPaid = totalLumpSumPaid;
    }

    public double getEmi() {
        return emi;
    }

    public double getTotalPayOffAmount() {
        return totalPayOffAmount;
    }

    public void setTotalPayOffAmount(double totalPayOffAmount) {
        this.totalPayOffAmount = totalPayOffAmount;
    }

    public void setEmi(double emi) {
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getEmiNumber() {
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
