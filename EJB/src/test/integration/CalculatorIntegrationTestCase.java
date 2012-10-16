package test.integration;

import calculator.local.CalculatorLocalBusiness;
import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import test.assertions.CalculatorAssertionDelegate;

import javax.ejb.EJB;

/**
 * User: Anton
 * Date: 16.10.12
 * Time: 18:18
 */
public class CalculatorIntegrationTestCase {
    private static final Logger log = Logger.getLogger(CalculatorIntegrationTestCase.class);

    @EJB
    private CalculatorLocalBusiness calculatorLocalBusiness;

    private static CalculatorAssertionDelegate calculatorAssertionDelegate;


    @BeforeClass
    public static void beforeClass() {
        calculatorAssertionDelegate = new CalculatorAssertionDelegate();
    }

    @Test
    public void testAdditionUsingBusinessReference() {
        log.info("Testing EJB via business reference...");
        calculatorAssertionDelegate.assertAdditionSucceeds(calculatorLocalBusiness);
    }
}
