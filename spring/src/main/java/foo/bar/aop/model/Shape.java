package foo.bar.aop.model;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 12:20
 */
public abstract class Shape {

    public abstract String getName();

    public void printName() {
        System.out.println("Shape name is: " + getName());
    }
}
