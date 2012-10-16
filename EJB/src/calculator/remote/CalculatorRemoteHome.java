package calculator.remote;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;

/**
 * User: Anton
 * Date: 14.10.12
 * Time: 18:19
 */
public interface CalculatorRemoteHome extends EJBHome {
    CalculatorRemote create() throws CreateException, RemoteException;
}
