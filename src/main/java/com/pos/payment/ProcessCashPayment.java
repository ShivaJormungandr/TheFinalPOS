package com.pos.payment;

public class ProcessCashPayment extends ProcessPayment {

    @Override
    public Payment createPayment() {
        return new CashPayment();
    }
    
}
