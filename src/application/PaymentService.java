package org.nacha.paymentsystem.application;


public class PaymentService {
    public void processPayment(Payment payment) {
        // Business logic for processing a payment

        if (!payment) {
            System.out.println("No payment received");
        }

        // proper handling of ACH accessible transaction
        // data can move, so must be secure
        PaymentService p1 = new PaymentService();
        System.out.println(int(payment));
    }

    public void validatePayment(Payment payment) {
        // Validation logic
    }

}
