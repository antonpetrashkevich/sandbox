package integration;

import junit.framework.TestCase;
import org.jboss.logging.Logger;
import org.junit.BeforeClass;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * User: Anton
 * Date: 17.10.12
 * Time: 15:43
 */
public class BasicEJBIntegrationTest extends TestCase {

    private static final Logger log = Logger.getLogger(BasicEJBIntegrationTest.class);
    protected InitialContext initialContext;

    @BeforeClass
    public void initialize() {
        checkEJBJarLoaded();
        initializeContext();
    }

    private void initializeContext() {
        try {
            initialContext = new InitialContext();
        } catch (NamingException e) {
            log.error("initialContext failed to be created", e);
        }
    }

    private void checkEJBJarLoaded() {
        boolean jarLoaded = false;
        Enumeration<URL> ejbJars =
                null;
        try {
            ejbJars = this.getClass().getClassLoader().getResources("META-INF/ejb-jar.xml");
        } catch (IOException e) {
            log.error("ejb-jar.xml could not be found", e);
        }
        while (ejbJars.hasMoreElements()) {
            URL url = ejbJars.nextElement();
            jarLoaded = true;
            log.debug("app = " + url);
        }
//        assertTrue("jar was not loaded properly", jarLoaded);
    }
}
