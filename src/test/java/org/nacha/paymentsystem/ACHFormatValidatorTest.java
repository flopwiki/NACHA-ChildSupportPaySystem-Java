package org.nacha.paymentsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ACHFormatValidatorTest {

    @Test
    void testValidACHFormat() {
        String validACH = "CCD+";
        assertTrue(ACHFormatValidator.isvalidACH(validACH));
    }

    @Test
    void testInvalidACHFormat() {
        String invalidACH = "State is using CCD+";
        assertFalse(ACHFormatValidator.isvalidACH(invalidACH));
    }
}
