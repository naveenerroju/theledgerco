package com.ledger.service;

import com.ledger.dto.Inputs;

public class ServiceFactory {


    /**
     * This method will provide the appropriate service for the specified serviceName.
     * @param service name of the service
     * @return the service
     */
    public LedgerEntry getService(String service){

        if(service.equals(Inputs.LOAN.name())){
            return new LoanService();
        } else if (service.equals(Inputs.PAYMENT.name())) {
            return new PaymentService();
        } else {
            return new BalanceService();
        }

    }


}
