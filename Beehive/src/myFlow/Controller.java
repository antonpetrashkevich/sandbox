package myFlow;

import controls.HelloWorld;
import forms.ProfileForm;
import org.apache.beehive.controls.api.bean.Control;
import org.apache.beehive.netui.pageflow.Forward;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.annotations.Jpf;

@Jpf.Controller(
        simpleActions = {
                @Jpf.SimpleAction(name = "begin", path = "index.jsp"),
                @Jpf.SimpleAction(name = "toPage2", path = "page2.jsp")
        }
)
public class Controller
        extends PageFlowController {


    @Control
    private HelloWorld helloWorld;


    @Jpf.Action(
            forwards = {
                    @Jpf.Forward(name = "success", path = "displayData.jsp")
            }
    )
    public Forward processData(ProfileForm form) {
        System.out.println("Name: " + form.getName());
        System.out.println("Age: " + form.getAge());

        Forward fwd = new Forward("success");

        fwd.addActionOutput("name", form.getName());
        fwd.addActionOutput("age", form.getAge());
        fwd.addActionOutput("message", helloWorld.helloParam(form.getName()));

        return fwd;
    }

}