package com.ledger.mapper;

import com.ledger.dto.Loan;
import com.ledger.dto.LoanRecord;

public class LoanRecordMapperImpl implements LoanRecordMapper {

    @Override
    public LoanRecord loanModelToRecord(Loan loan) {
        LoanRecord loanRecord = new LoanRecord();
        loanRecord.setBankName(loan.getBankName());
        loanRecord.setBorrowerName(loan.getBorrowerName());
        loanRecord.setPrinciple(loan.getPrincipalAmount());
        loanRecord.setTenure(loan.getNoOfYears());
        loanRecord.setInterest(loan.getRateOfInterest());
        loanRecord.setEmiNumber(0);
        loanRecord.setTotalLumpSumPaid(0L);

        return loanRecord;
    }

}
