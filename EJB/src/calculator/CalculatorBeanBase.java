package calculator;

import org.jboss.logging.Logger;

/**
 * User: Anton
 * Date: 14.10.12
 * Time: 17:59
 */
public class CalculatorBeanBase implements CalculatorCommonBusiness {

    private static final Logger log = Logger.getLogger(CalculatorBeanBase.class);

    @Override
    public int add(int... arguments) {
        // Initialize
        final StringBuffer sb = new StringBuffer();
        sb.append("Adding arguments: ");
        int result = 0;
// Add all arguments
        for (final int arg : arguments) {
            result += arg;
            sb.append(arg);
            sb.append(" ");
        }
// Return
        log.info(sb.toString());
        log.info("Result: " + result);
        return result;
    }
}
