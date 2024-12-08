package org.nacha.paymentsystem.infrastructure.persistence;

import org.nacha.paymentsystem.domain.Payment;
import org.springframework.data.jpa.repository.JpaRespository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}