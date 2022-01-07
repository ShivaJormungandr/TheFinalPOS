/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.payment;

/**
 *
 * @author Tavi
 */
public class CashPayment implements Payment {

        @Override
        public String pay() {
            return "Thank you for using our services! Next time prese use card, is safer!";
        }
}
