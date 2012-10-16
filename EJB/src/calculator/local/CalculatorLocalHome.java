package calculator.local;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 * User: Anton
 * Date: 14.10.12
 * Time: 18:19
 */
public interface CalculatorLocalHome extends EJBLocalHome {
    CalculatorLocal create() throws CreateException;
}
