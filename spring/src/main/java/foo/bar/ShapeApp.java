package foo.bar;

import foo.bar.aop.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 13:40
 */
public class ShapeApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        ShapeService shapeService = (ShapeService) context.getBean("ss");

        shapeService.getCircle().printName();
    }
}
