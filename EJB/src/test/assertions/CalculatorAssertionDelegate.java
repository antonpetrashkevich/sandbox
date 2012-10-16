package test.assertions;

import calculator.CalculatorCommonBusiness;
import junit.framework.TestCase;
import org.jboss.logging.Logger;

/**
 * User: Anton
 * Date: 16.10.12
 * Time: 18:25
 */
public class CalculatorAssertionDelegate {

    // ---------------------------------------------------------------------------||
// Class Members -------------------------------------------------------------||
// ---------------------------------------------------------------------------||
    /**
     * Logger
     */
    private static final Logger log = Logger.getLogger(CalculatorAssertionDelegate
            .class);
// ---------------------------------------------------------------------------||
// Functional Methods --------------------------------------------------------||
// ---------------------------------------------------------------------------||

    /**
     * Uses the supplied Calculator instance to test the addition
     * algorithm
     */
    public void assertAdditionSucceeds(final CalculatorCommonBusiness calc) {
// Initialize
        final int[] arguments = new int[]
                {2, 3, 5};
        final int expectedSum = 10;
// Add
        final int actualSum = calc.add(arguments);
// Test
        TestCase.assertEquals("Addition did not return the expected result",
                expectedSum, actualSum);
// Log
        final StringBuffer sb = new StringBuffer();
        sb.append("Obtained expected result, ");
        sb.append(actualSum);
        sb.append(", from arguments: ");
        for (final int arg : arguments) {
            sb.append(arg);
            sb.append(" ");
        }
        log.info(sb.toString());
    }

}
