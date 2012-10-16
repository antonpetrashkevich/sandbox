package calculator;

import calculator.local.CalculatorLocalBusiness;
import calculator.local.CalculatorLocalHome;
import calculator.remote.CalculatorRemoteBusiness;
import calculator.remote.CalculatorRemoteHome;

import javax.ejb.*;

/**
 * User: Anton
 * Date: 16.10.12
 * Time: 17:14
 */
@Stateless
@Local(CalculatorLocalBusiness.class)
@LocalHome(CalculatorLocalHome.class)
@Remote(CalculatorRemoteBusiness.class)
@RemoteHome(CalculatorRemoteHome.class)
@LocalBean
public class ManyViewCalculatorBean extends CalculatorBeanBase implements CalculatorCommonBusiness {
    public void ejbCreate() throws CreateException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
