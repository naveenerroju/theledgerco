package com.ledger.dto;

public class LoanRecord {
    private String bankName;
    private String borrowerName;
    private long principle;
    private int interest;
    private int tenure;
    private long balance;
    private int emi;

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

    public int getEmi() {
        return emi;
    }

    public void setEmi(int emi) {
        this.emi = emi;
    }

    public LoanRecord(String bankName, String borrowerName, long principle, int interest, int tenure, long balance, int emi) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principle = principle;
        this.interest = interest;
        this.tenure = tenure;
        this.balance = balance;
        this.emi = emi;
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
                ", emi=" + emi +
                '}';
    }
}
