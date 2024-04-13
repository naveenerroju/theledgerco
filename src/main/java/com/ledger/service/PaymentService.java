package com.ledger.service;

import com.ledger.utils.Utility;

public class PaymentService implements LedgerEntry{
    @Override
    public void perform(String command) {
        Utility.logInfo(command);
    }
}
