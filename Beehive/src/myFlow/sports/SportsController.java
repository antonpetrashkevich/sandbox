package myFlow.sports;

import org.apache.beehive.netui.pageflow.annotations.Jpf;
import org.apache.beehive.netui.pageflow.PageFlowController;
import org.apache.beehive.netui.pageflow.Forward;

@Jpf.Controller(
        nested = true,
        simpleActions = {
                @Jpf.SimpleAction(name="begin", path="index.jsp")
        }
)
public class SportsController
        extends PageFlowController {

    private String selectedSport;
    private String[] sports = {"sailing", "surfing", "diving", "volleyball", "bicycling"};

    public String[] getSports() {
        return sports;
    }

    public String getSelectedSport() {
        return selectedSport;
    }

    @Jpf.Action(
            forwards = {
                    @Jpf.Forward(name="confirm", path="confirm.jsp")
            }
    )
    public Forward selectSport(SportForm form) {
        selectedSport = form.getSport();
        return new Forward("confirm");
    }

    @Jpf.Action(
            forwards = {
                    @Jpf.Forward(
                            name="success",
                            returnAction="sportSelected",
                            outputFormBeanType=String.class)
            }
    )
    public Forward confirm() {
        return new Forward("success", selectedSport);
    }

    public static class SportForm
            implements java.io.Serializable {

        private String sport;

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getSport() {
            return this.sport;
        }
    }
}