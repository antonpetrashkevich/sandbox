package foo.bar.aop.model;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 12:20
 */
public class Circle extends Shape {


    @Value("#{hellomessages.hello}")
    private String helloMessage;

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Required
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
