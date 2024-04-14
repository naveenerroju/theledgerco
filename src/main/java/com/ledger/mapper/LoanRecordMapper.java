package com.ledger.mapper;

import com.ledger.dto.Loan;
import com.ledger.dto.LoanRecord;

@FunctionalInterface
public interface LoanRecordMapper {
    LoanRecord loanModelToRecord(Loan loan);
}
