package org.nacha.paymentsystem.application;
import org.springframework.web.bind.annotation.*;
import org.nacha.paymentsystem.domain.Payment;
import org.nacha.paymentsystem.application.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public String createPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
        return "Payment process successfully";
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }


}
