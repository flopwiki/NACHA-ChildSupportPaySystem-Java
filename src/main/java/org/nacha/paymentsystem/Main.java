package org.nacha.paymentsystem;
import org.nacha.paymentsystem.Welcome.Welcome;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println(Welcome.getWelcomeMessage());
        Logger logger = Logger.getLogger(Logger.getLogger("Main").getName());
        logger.info("Initializing payment system....completed");
    }
}
