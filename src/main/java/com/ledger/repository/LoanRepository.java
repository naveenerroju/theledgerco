package com.ledger.repository;

import com.ledger.dto.LoanRecord;

public interface LoanRepository {
    public LoanRecord getLoanRecordByBorrowerName(String name);
    public LoanRecord save(LoanRecord loanRecord);
}
