package com.ledger.service;

import com.ledger.dto.Loan;
import com.ledger.dto.LoanRecord;
import com.ledger.exception.BusinessException;
import com.ledger.mapper.LoanRecordMapperImpl;
import com.ledger.repository.LoanRepositoryImpl;
import com.ledger.utils.Utility;

public class LoanService implements LedgerEntry {

    private final LoanRecordMapperImpl mapper = new LoanRecordMapperImpl();
    private final LoanRepositoryImpl repository;

    public LoanService(LoanRepositoryImpl repository) {
        this.repository = repository;
    }

    /**
     * <p>The LOAN command receives a Bank name, Borrower name, Principal Amount, No of Years of Loan period and the Rate of Interest along with it.</p>
     * <p>Format - LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST</p>
     * <p>Example- LOAN IDIDI Dale 10000 5 4 means a loan amount of 10000 is paid to Dale by IDIDI for a tenure of 5 years at 4% rate of interest.</p>
     * <p>It validates if the provided command is actually for Loan </p>
     * @param command Format - LOAN, BANK_NAME, BORROWER_NAME, PRINCIPAL, NO_OF_YEARS, RATE_OF_INTEREST
     *                <p>Example- LOAN IDIDI Dale 10000 5 4 means a loan amount of 10000 is paid to Dale by IDIDI for a tenure of 5 years at 4% rate of interest.</p>
     */
    @Override
    public void perform(String command) {

        Loan loanModel = generateLoanModel(command);
        LoanRecord loanRecord = mapper.loanModelToRecord(loanModel);
        loanRecord.setTotalPayOffAmount(Utility.calculateTotalInterest(loanModel));
        loanRecord.setEmi(Utility.caclulateEmi(loanRecord));
        repository.save(loanRecord);

    }

    private Loan generateLoanModel(String command) {
        String[] parts = command.split(" ");

        if (parts.length != 6 || !parts[0].equalsIgnoreCase("LOAN")) {
            throw new BusinessException("Invalid loan string format");
        }

        String bankName = parts[1];
        String borrowerName = parts[2];
        long principalAmount = Long.parseLong(parts[3]);
        int noOfYears = Integer.parseInt(parts[4]);
        int rateOfInterest = Integer.parseInt(parts[5]);
        return new Loan(bankName, borrowerName, principalAmount, noOfYears, rateOfInterest);
    }


}
