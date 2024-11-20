package org.nacha.paymentsystem;

import com.company.paymentsystem.util.Logger;

public class ACHGateway {
    public boolean sendPayment(String accountNumber, double amount) {
        // Encrypt account number for security
        String encryptedAccount = encryptData(accountNumber);

        // Send payment to ACH
        try {
            Logger.info("Sending payment to ACH: " + encryptedAccount);
            // Simulate sending payment
            return true;
        } catch (Exception e) {
            Logger.error("Failed to send payment", e);
            return false;
        }
    }

    private String encryptData(String data) {
        // Simulate encryption (use real encryption like AES in production)
        return "ENCRYPTED_" + data;
    }
}