package org.nacha.paymentsystem;

/*
*
* API integration with ACH network
* */

class ACHFormatValidator {
    public static boolean isvalidACH(String ach_format) {
        return ach_format.equals("CCD+");
    }
}