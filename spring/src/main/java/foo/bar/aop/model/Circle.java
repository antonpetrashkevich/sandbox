package foo.bar.aop.model;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 12:20
 */
public class Circle extends Shape {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                '}';
    }
}
