package com.pos.payment;

public class ProcessCardPayment extends ProcessPayment{

    @Override
    public Payment createPayment() {
        return new CardPayment();
    }
    
}
