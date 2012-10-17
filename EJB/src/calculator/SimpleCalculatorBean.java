package calculator;

import calculator.local.CalculatorLocalBusiness;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * User: Anton
 * Date: 16.10.12
 * Time: 17:35
 */
@Stateless(name = "SimpleCalculatorBean")
@Local(CalculatorLocalBusiness.class)
public class SimpleCalculatorBean extends CalculatorBeanBase implements CalculatorCommonBusiness {
}
