package com.ledger.service;

import com.ledger.dto.Inputs;
import com.ledger.dto.LoanRecord;
import com.ledger.dto.Payment;
import com.ledger.exception.BusinessException;
import com.ledger.repository.LoanRepositoryImpl;
import com.ledger.utils.Utility;

public class PaymentService implements LedgerEntry {

    private final LoanRepositoryImpl repository;

    public PaymentService(LoanRepositoryImpl repository) {
        this.repository = repository;
    }

    /**
     * <p>The PaymentService.perform() receives a Bank name, Borrower name, Lump sum amount and EMI number along with it. The EMI number indicates that the lump sum payment is done after that EMI.</p>
     * <p>This method has two validations. 1. It validates if the given borrower name exists in loans record. {@link ServiceHelper#validateRecordRequest(LoanRecord, String)} 2. It validates if the provided command is actually for Balance </p>
     * @param command Format - PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO
     *                <p>Example - PAYMENT MBI Dale 1000 5 means a lump sum payment of 1000 was done by Dale to MBI after 5 EMI payments.</p>
     */
    @Override
    public void perform(String command) {
        Payment payment = generatePaymentModel(command);
        LoanRecord loanRecord = repository.getLoanRecordByBorrowerName(payment.getBorrowerName());
        ServiceHelper.validateRecordRequest(loanRecord, payment.getBorrowerName());
        loanRecord.setEmiNumber(payment.getEmiNumber());
        long totalAmountPaid = Utility.calculateTheAmountPaid(loanRecord);
        loanRecord.setTotalLumpSumPaid(payment.getLumpSumAmount() + loanRecord.getTotalLumpSumPaid());
        loanRecord.setBalance(loanRecord.getPrinciple() - totalAmountPaid);
    }

    private Payment generatePaymentModel(String command) {
        String[] parts = command.split(" ");

        if (parts.length != 5 || !parts[0].equalsIgnoreCase(Inputs.PAYMENT.toString())) {
            throw new BusinessException("Invalid PAYMENT string format");
        }

        String bankName = parts[1];
        String borrowerName = parts[2];
        long lumpSumAmount = Long.parseLong(parts[3]);
        int emiNumber = Integer.parseInt(parts[4]);

        return new Payment(bankName, borrowerName, lumpSumAmount, emiNumber);

    }
}
