package org.nacha.paymentsystem;

import org.nacha.paymentsystem.Welcome.Welcome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testWelcomeMessage() {
        // Testing the output of the main logic (example)
        String expected = "Welcome to the Child Support Payment System";
        Welcome Welcome = new Welcome();
        assertEquals(expected, Welcome.getWelcomeMessage());
    }
}
