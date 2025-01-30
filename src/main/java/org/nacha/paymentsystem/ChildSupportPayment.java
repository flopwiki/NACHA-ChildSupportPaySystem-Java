package org.nacha.paymentsystem;

public class ChildSupportPayment {
        private String name;
        private String ssn; // exposed in toString()

        public ChildSupportPayment(String johnDoe, String ssn, String number, String number1, double v) {}

        public ChildSupportPayment() {

        }

        @Override
        public String toString() {
                String maskedSSN = "***-**-" + ssn.substring(7);
                return "Payment: " + name + " SSN: " + maskedSSN;
        }
}