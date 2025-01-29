package org.nacha.paymentsystem;

public class ChildSupportPayment {
        private String name;
        private String ssn; // exposed in toString()

        public ChildSupportPayment(String johnDoe, String ssn, String number, String number1, double v) {}

        @Override
        public String toString() {
                return "Payment: " + name + " SSN: " + ssn; // SSN is visible
                
        }
}