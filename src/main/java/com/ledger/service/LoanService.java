package com.ledger.service;

import com.ledger.utils.Utility;

public class LoanService implements LedgerEntry{
    @Override
    public void perform(String command) {
        Utility.logInfo(command);
    }
}
