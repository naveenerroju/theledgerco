package com.ledger.service;

import com.ledger.dto.Balance;
import com.ledger.dto.LoanRecord;
import com.ledger.exception.BusinessException;
import com.ledger.repository.LoanRepositoryImpl;
import com.ledger.utils.Utility;

public class BalanceService implements LedgerEntry{

    private final LoanRepositoryImpl repository;

    public BalanceService(LoanRepositoryImpl repository) {
        this.repository = repository;
    }

    /**
     * <p>The BalanceService.perform() receives a Bank name, Borrower name and a EMI number along with it. It prints the total amount paid by the borrower, including all the Lump Sum amounts paid including that EMI number, and the no of EMIs remaining.</p>
     * <p>Output format - BANK_NAME BORROWER_NAME AMOUNT_PAID NO_OF_EMIS_LEFT</p>
     * <pr>Example - MBI Harry 1250 43</pr>
     * <p>This method has two validations. 1. It validates if the given borrower name exists in loans record. {@link ServiceHelper#validateRecordRequest(LoanRecord, String)} 2. It validates if the provided command is actually for Balance </p>
     * @param command Input format - BALANCE BANK_NAME BORROWER_NAME EMI_NO
     *       <p>Example - BALANCE MBI Harry 12 means - print the amount paid including 12th EMI, and EMIs remaining for user Harry against the lender MBI.</p>
     *
     */
    @Override
    public void perform(String command) {

        Balance balance = generateBalanceModel(command);
        LoanRecord loanRecord = repository.getLoanRecordByBorrowerName(balance.getBorrowerName());
        ServiceHelper.validateRecordRequest(loanRecord, balance.getBorrowerName());
        loanRecord.setEmiNumber(balance.getEmiNumber());

        double totalAmountPaid = Utility.calculateTheAmountPaid(loanRecord);
        double totalEmiLeft = Utility.calculateTotalNumberOfEmiLeft(loanRecord);

        loanRecord.setTotalPayOffAmount(totalAmountPaid);
        loanRecord.setBalance(loanRecord.getPrinciple() - totalAmountPaid);

        String response = buildResponse(loanRecord, (int)Math.ceil(totalAmountPaid), (int)Math.ceil(totalEmiLeft));
        Utility.logInfo(response);
    }

    private Balance generateBalanceModel(String command){
        String[] parts = command.split(" ");

        if (parts.length != 4 || !parts[0].equalsIgnoreCase("BALANCE")) {
            throw new BusinessException("Invalid loan string format");
        }

        String bankName = parts[1];
        String borrowName = parts[2];
        int emi = Integer.parseInt(parts[3]);

        return new Balance(bankName, borrowName, emi);
    }

    private String buildResponse(LoanRecord loanRecord, long totalAmountPaid, long totalEmiLeft) {
        return loanRecord.getBankName() + " " + loanRecord.getBorrowerName() + " " + totalAmountPaid + " " + totalEmiLeft;
    }
}
