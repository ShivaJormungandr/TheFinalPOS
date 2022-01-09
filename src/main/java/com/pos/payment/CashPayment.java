package com.pos.payment;

public class CashPayment implements Payment {

        @Override
        public String pay() {
            return "Thank you for using our services! Next time prese use card, is safer!";
        }
}
