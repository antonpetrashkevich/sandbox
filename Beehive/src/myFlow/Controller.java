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
        },
        sharedFlowRefs = {
                @Jpf.SharedFlowRef(name = "shared", type = shared.SharedFlow.class)
        }
)
public class Controller
        extends PageFlowController {


    @Control
    private HelloWorld helloWorld;
    private ProfileForm profileForm;

    /**
     * This action forwards to the nested page flow to collect the sport
     * name.  Note that it takes a ProfileForm so we can update the form
     * with the sport name returned from the nested page flow, but we've
     * explicitly turned validation off for this action, since the form
     * may be incomplete.
     */
    @Jpf.Action(
            useFormBean = "profileForm",
            forwards = {
                    @Jpf.Forward(name = "getSportFlow", path = "sports/SportsController.jpf")
            },
            doValidation = false
    )
    protected Forward getSport(ProfileForm form) {
        return new Forward("getSportFlow");
    }

    /**
     * This action takes the sport name returned from the nested page flow
     * and updates the field in the form and returns to the original page.
     */
    @Jpf.Action(
            forwards = {
                    @Jpf.Forward(name = "success", navigateTo = Jpf.NavigateTo.currentPage)
            }
    )
    protected Forward sportSelected(String sport) {
        profileForm.setSport(sport);
        Forward success = new Forward("success", profileForm);
        return success;
    }

    @Jpf.Action(
            useFormBean = "profileForm",
            forwards = {
                    @Jpf.Forward(name = "success", path = "displayData.jsp")
            },
            validationErrorForward = @Jpf.Forward(name = "fail", path = "page2.jsp")
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