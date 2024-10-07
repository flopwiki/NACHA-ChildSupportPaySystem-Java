package org.nacha.paymentsystem.application;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public void processPayment(@RequestBody Payment payment) {
        paymentService.processPayment(payment);
    }

}
