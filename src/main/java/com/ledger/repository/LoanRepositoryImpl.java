package com.ledger.repository;

import com.ledger.dto.LoanRecord;

import java.util.ArrayList;
import java.util.List;

public class LoanRepositoryImpl implements LoanRepository{

    private final List<LoanRecord> loanRecords = new ArrayList<>();

    @Override
    public LoanRecord getLoanRecordByBorrowerName(String name) {
        for (LoanRecord loanRecord : loanRecords) {
            if(loanRecord.getBorrowerName().equals(name)){
                return loanRecord;
            }
        }
        return null;
    }

    @Override
    public LoanRecord save(LoanRecord loanRecord) {
        loanRecords.add(loanRecord);
        return loanRecord;
    }
}
