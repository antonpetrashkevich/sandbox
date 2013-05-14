package foo.bar.aop.model;

import foo.bar.aop.aspect.Loggable;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 12:20
 */
public abstract class Shape {

    public abstract String getName();

    @Loggable
    public void printName() {
        System.out.println("Shape name is: " + getName());
    }

    public void printShapesName(Shape shape) {
        shape.printName();
    }


}
