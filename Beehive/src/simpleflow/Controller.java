package simpleflow;

import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;

/**
 * User: APetrashkevich
 * Date: 15.03.13
 * Time: 16:03
 */

@Jpf.Controller(
        simpleActions = {
                @Jpf.SimpleAction(name = "begin", path = "index.jsp")
        }
)
public class Controller
        extends PageFlowController {
}