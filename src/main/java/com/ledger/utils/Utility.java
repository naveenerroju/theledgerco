package com.ledger.utils;

import com.ledger.dto.Loan;
import com.ledger.dto.LoanRecord;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains static methods used for utility.
 * Example: loggers, calculations.
 * <p/>
 * This class cannot be instantiated.
 */
public class Utility {

    /**
     * This is a utility class. This shouldn't be instantiated. Hence, making it a private constructor.
     */
    private Utility() {}
    static Logger logger = Logger.getLogger(Utility.class.getName());

    /**
     * Logs errors with SEVERE level.
     * @param message message to be printed
     * @param e caught exception
     */
    public static void logError(String message, Exception e) {
        logger.log(Level.SEVERE, message, e);
    }

    /**
     * Logs info with INFO level.
     * @param message message to be printed
     */
    public static void logInfo(String message) {
        //logger.log(Level.INFO, message);
        System.out.println(message);
    }

    /**
     * <p>The interest for the loan is calculated by I = P*N*R where P is the principal amount, N is the number of years and R is the rate of interest.</p>
     * Formula: <pre>{@code
     * (int) principalAmount * rateOfInterest * numberOfYears;
     * }</pre>
     * @param loan Loan with required fields for calculation
     * @return P*N*R
     */
    public static long calculateTotalPayOff(Loan loan){
        long principalAmount = loan.getPrincipalAmount();
        double rateOfInterest = (double) loan.getRateOfInterest() / 100; // Convert percentage to decimal
        int numberOfYears = loan.getNoOfYears();

        double totalInterest = principalAmount * rateOfInterest * numberOfYears;

        return Math.round(principalAmount + totalInterest);
    }

    /**
     * Calculates the total amount paid so far by the borrower.
     * Formula: <pre>{@code
     *  (long) loanRecord.getEmi() *emiNumber;
     * }</pre>
     * @param loanRecord LoanRecord with totalLumpSum, emiNumber and emi
     * @return totalEmiPaid+totalLumpSumPaid
     */
    public static double calculateTheAmountPaid(LoanRecord loanRecord){
        long totalLumpSumPaid = loanRecord.getTotalLumpSumPaid();
        double totalEmiPaid = (loanRecord.getEmiNumber() * loanRecord.getEmi());

        return totalEmiPaid+totalLumpSumPaid;
    }

    /**
     * <p>Calculates the total amount yet to pay. This includes the EMI paid and the lumpSumAmountPaid</p>
     * <p>This method uses {@link Utility#calculateTheAmountPaid(LoanRecord)} to calculate the totalAmountPaid</p>
     * @param loanRecord LoanRecord containing emi, emiNumber and lumpSumAmountPaid
     * @return totalEmiPaid+totalLumpSumPaid;
     */
    public static double calculateTheAmountLeft(LoanRecord loanRecord){
        return loanRecord.getTotalPayOffAmount()-Utility.calculateTheAmountPaid(loanRecord);
    }


    /**
     * <p>Calculate the total number of emis left for the borrower. This uses the total amount left and divides it with the emi amount</p>
     * <p>This method uses {@link Utility#calculateTheAmountLeft(LoanRecord)} to calculate the totalAmountLeft</p>
     * @param loanRecord LoanRecord with emi field
     * @return (int) (totalAmountLeft/loanRecord.getEmi())
     */
    public static double calculateTotalNumberOfEmiLeft(LoanRecord loanRecord){
        double totalAmountLeft = Utility.calculateTheAmountLeft(loanRecord);
        return (totalAmountLeft/loanRecord.getEmi());
    }

    public static double calculateEmi(LoanRecord loanRecord){
        long principal = loanRecord.getPrinciple();
        double interestRate = (double) loanRecord.getInterest() / 1200; // Convert annual interest rate to monthly rate
        int tenure = loanRecord.getTenure()*12;

        return ((principal * interestRate * Math.pow(1 + interestRate, tenure)) / (Math.pow(1 + interestRate, tenure) - 1));
    }

    public static String listToString(List<LoanRecord> loanRecordList){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < loanRecordList.size(); i++) {
            sb.append(loanRecordList.get(i));
            if (i < loanRecordList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
