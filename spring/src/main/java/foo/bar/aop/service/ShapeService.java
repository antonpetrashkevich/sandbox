package foo.bar.aop.service;

import foo.bar.aop.model.Circle;
import foo.bar.aop.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Anton
 * Date: 14.05.13
 * Time: 13:32
 */


@Service(value = "ss")
public class ShapeService {

    @Autowired
    private Circle circle;
    @Autowired
    private Triangle triangle;


    public Circle getCircle() {
        return circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }
}
