package forms;

import org.apache.beehive.netui.pageflow.annotations.Jpf;

/**
 * User: APetrashkevich
 * Date: 18.03.13
 * Time: 14:15
 */
public class ProfileForm
        implements java.io.Serializable {

    private int age;
    private String name;
    private String sport;

    @Jpf.ValidatableProperty(
            displayName = "Name",
            validateRequired = @Jpf.ValidateRequired(),
            validateMaxLength = @Jpf.ValidateMaxLength(chars = 30)
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Jpf.ValidatableProperty(
            displayName = "Age",
            validateRange = @Jpf.ValidateRange(minInt = 1, maxInt = 130)
    )
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return this.sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}