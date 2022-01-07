/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.payment;

/**
 *
 * Will produce a 
 */
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
