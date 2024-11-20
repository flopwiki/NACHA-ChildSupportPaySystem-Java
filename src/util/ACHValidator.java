package org.nacha.paymentsystem;

public class ACHValidator {
    public static boolean isValidAccountNumber(String accountNumber) {
        // Validate length and format (e.g., numeric, 9-12 digits)
        return accountNumber != null && accountNumber.matches("\\d{9,12}");
    }

    public static boolean isValidRoutingNumber(String routingNumber) {
        // Validate format (e.g., numeric, 9 digits)
        return routingNumber != null && routingNumber.matches("\\d{9}");
    }
}