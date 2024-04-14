package com.ledger.utils;

import com.ledger.dto.Loan;
import com.ledger.dto.LoanRecord;

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
        logger.log(Level.INFO, message);
    }

    /**
     * <p>The interest for the loan is calculated by I = P*N*R where P is the principal amount, N is the number of years and R is the rate of interest.</p>
     * Formula: <pre>{@code
     * (int) principalAmount * rateOfInterest * numberOfYears;
     * }</pre>
     * @param loan Loan with required fields for calculation
     * @return P*N*R
     */
    public static int calculateTotalInterest(Loan loan){
        long principalAmount = loan.getPrincipalAmount();
        int rateOfInterest = loan.getRateOfInterest();
        int numberOfYears = loan.getNoOfYears();
        return (int) principalAmount * rateOfInterest * numberOfYears;
    }

    /**
     * Calculates the total amount paid so far by the borrower.
     * Formula: <pre>{@code
     *  (long) loanRecord.getEmi() *emiNumber;
     * }</pre>
     * @param loanRecord LoanRecord with totalLumpSum, emiNumber and emi
     * @return totalEmiPaid+totalLumpSumPaid
     */
    public static long calculateTheAmountPaid(LoanRecord loanRecord){
        long totalLumpSumPaid = loanRecord.getTotalLumpSumPaid();
        long totalEmiPaid = (long) loanRecord.getEmiNumber() * loanRecord.getEmi();

        return totalEmiPaid+totalLumpSumPaid;
    }

    /**
     * <p>Calculates the total amount yet to pay. This includes the EMI paid and the lumpSumAmountPaid</p>
     * <p>This method uses {@link Utility#calculateTheAmountPaid(LoanRecord)} to calculate the totalAmountPaid</p>
     * @param loanRecord LoanRecord containing emi, emiNumber and lumpSumAmountPaid
     * @return totalEmiPaid+totalLumpSumPaid;
     */
    public static long calculateTheAmountLeft(LoanRecord loanRecord){
        return loanRecord.getTotalPayOffAmount()-Utility.calculateTheAmountPaid(loanRecord);
    }


    /**
     * <p>Calculate the total number of emis left for the borrower. This uses the total amount left and divides it with the emi amount</p>
     * <p>This method uses {@link Utility#calculateTheAmountLeft(LoanRecord)} to calculate the totalAmountLeft</p>
     * @param loanRecord LoanRecord with emi field
     * @return (int) (totalAmountLeft/loanRecord.getEmi())
     */
    public static int calculateTotalNumberOfEmiLeft(LoanRecord loanRecord){
        long totalAmountLeft = Utility.calculateTheAmountLeft(loanRecord);
        return (int) (totalAmountLeft/loanRecord.getEmi());
    }

    public static int caclulateEmi(LoanRecord loanRecord){
        long principal = loanRecord.getPrinciple();
        int interestRate = loanRecord.getInterest();
        int tenure = loanRecord.getTenure();
        return (int) ((principal * interestRate) / (1 - Math.pow((double)1 + interestRate, -tenure)));
    }

}
