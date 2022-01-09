package com.pos.payment;

public class CardPayment implements Payment {

    @Override
    public String pay() {
        return "Thanks for paying with the card";
    }
}
