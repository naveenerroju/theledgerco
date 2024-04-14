package com.ledger.service;

import com.ledger.dto.LoanRecord;
import com.ledger.exception.BusinessException;

public class ServiceHelper {
    public static void validateRecordRequest(LoanRecord loanRecord, String borrowerName) {
        if (null == loanRecord) {
            throw new BusinessException("No loan record found for " + borrowerName);
        }
    }
}
