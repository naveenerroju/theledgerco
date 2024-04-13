package com.ledger.service;

@FunctionalInterface
public interface LedgerEntry {
    public void perform(String command);
}
