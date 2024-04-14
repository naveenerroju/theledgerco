package com.ledger.service;

import com.ledger.dto.Inputs;
import com.ledger.repository.LoanRepositoryImpl;

public class ServiceFactory {


    /**
     * This method will provide the appropriate service for the specified serviceName.
     * @param service name of the service
     * @return the service
     */
    public LedgerEntry getService(LoanRepositoryImpl repository, String service){

        if(service.equals(Inputs.LOAN.name())){
            return new LoanService(repository);
        } else if (service.equals(Inputs.PAYMENT.name())) {
            return new PaymentService(repository);
        } else {
            return new BalanceService(repository);
        }

    }


}
