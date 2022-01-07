/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.payment;

/**
 *
 * @author Tavi
 */
public class ProcessCardPayment extends ProcessPayment{

    @Override
    public Payment createPayment() {
        return new CardPayment();
    }
    
}
