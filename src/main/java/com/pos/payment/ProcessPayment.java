package com.pos.payment;

public abstract class ProcessPayment {
    private String paymentResponse = null;
    
    public void pay(){      
        Payment payment = createPayment();
        paymentResponse = payment.pay();
    }
    
    public String getpaymentResponse(){
        return paymentResponse;
    }
    
    public abstract Payment createPayment();
}
