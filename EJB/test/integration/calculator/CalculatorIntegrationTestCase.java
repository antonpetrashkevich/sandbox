package integration.calculator;

import assertions.CalculatorAssertionDelegate;
import calculator.local.CalculatorLocalBusiness;
import integration.BasicEJBIntegrationTest;
import org.jboss.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.NamingException;

/**
 * User: Anton
 * Date: 16.10.12
 * Time: 18:18
 */
public class CalculatorIntegrationTestCase extends BasicEJBIntegrationTest {
    private static final Logger log = Logger.getLogger(CalculatorIntegrationTestCase.class);

    private CalculatorLocalBusiness calculatorLocalBusiness;

    private static CalculatorAssertionDelegate calculatorAssertionDelegate;


    @BeforeClass
    public void setUpBean() {
        calculatorAssertionDelegate = new CalculatorAssertionDelegate();
        try {
            calculatorLocalBusiness = (CalculatorLocalBusiness) initialContext.lookup("SimpleCalculatorBeanLocal");
        } catch (NamingException e) {
            log.error("SimpleCalculatorBean failed to initialize", e);
            try {
                initialContext.close();
            } catch (NamingException e1) {
                log.error(e);
            }
        }

    }

    @Test
    public void testAdditionUsingBusinessReference() {
        log.debug("Testing EJB via business reference...");
        initialize();
        setUpBean();
        calculatorAssertionDelegate.assertAdditionSucceeds(calculatorLocalBusiness);
    }
}
