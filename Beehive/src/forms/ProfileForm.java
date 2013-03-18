package forms;

/**
 * User: APetrashkevich
 * Date: 18.03.13
 * Time: 14:15
 */
public class ProfileForm
        implements java.io.Serializable {

    private int age;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}