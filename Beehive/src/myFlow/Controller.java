package myFlow;

import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.PageFlowController;

@Jpf.Controller(
        simpleActions={
                @Jpf.SimpleAction(name="begin", path="index.jsp")
        }
)
public class Controller
        extends PageFlowController
{
}