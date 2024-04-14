package com.ledger.dto;

public class Loan {
    private String bankName;
    private String borrowerName;
    private long principalAmount;
    private int noOfYears;
    private int rateOfInterest;

    public Loan(String bankName, String borrowerName, long principalAmount, int noOfYears, int rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principalAmount = principalAmount;
        this.noOfYears = noOfYears;
        this.rateOfInterest = rateOfInterest;
    }

    public Loan() {
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

    public long getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(long principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(int noOfYears) {
        this.noOfYears = noOfYears;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "bankName='" + bankName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", principalAmmount=" + principalAmount +
                ", noOfYears=" + noOfYears +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
