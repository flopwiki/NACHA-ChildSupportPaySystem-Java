org.nacha.paymentsystem.Main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testWelcomeMessge() {
        // Testing the output of the main logic (example)
        String expected = "Welcome to the Child Support Payment System";
        assertEqual(expected, Main.getWelcomeMessage());
    }
}
