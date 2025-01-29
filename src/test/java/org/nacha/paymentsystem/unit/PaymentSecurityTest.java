package org.nacha.paymentsystem.unit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.logging.Logger;

public class PaymentSecurityTest {

        @Test
        void testSSNIsNotLoggedInPlaintext() {
                //arrange
                Logger mockLogger = mock(Logger.class);
                String ssn = "123-45-8879";
                org.nacha.paymentsystem.ChildSupportPayment payment = new org.nacha.paymentsystem.ChildSupportPayment(
                        "John Doe", ssn, "987780874", "987654321", 500.00
                );

                // act: simulate logging the payment object
                // assume the system logs payment details internally
                mockLogger.info(payment.toString());

                // assert: verify the log does not contain raw ssn
                String loggedMessage = payment.toString();
                assertFalse(loggedMessage.contains(ssn),
                "SSN was logged in plaintext!");
        }
}
