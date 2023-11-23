package com.map.Domain.payment.paymentMethodes;
import com.map.Domain.payment.PaymentStrategy;

public class MasterCard implements PaymentStrategy {
        @Override
        public void processPayment(double amount) {
            System.out.println("Paid " + amount + " RON using MasterCard.");
        }

}
