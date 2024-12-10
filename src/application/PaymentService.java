package org.nacha.paymentsystem.application;

import org.nacha.paymentsystem.domain.Payment;
import org.nacha.paymentsystem.infrastructure.persistence.PaymentRespository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRespository paymentRespository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRespository = paymentRepository;
    }

    public void processPayment(Payment payment) {
        // Business logic for processing a payment
        if (!payment) {
            System.out.println("No payment received");
        }
        validatePayment(payment);
        paymentRespository.save(payment);

        // additional logic (e.g., remittance instructions, message)
    }

    public Payment getPaymentById(Long id) {
        return paymentRespository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public void validatePayment(Payment payment) {
        // Validation logic
    }

    public String findById(Long id) {
        return "data found"
    }

}
