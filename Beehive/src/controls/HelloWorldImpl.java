package controls;


import org.apache.beehive.controls.api.bean.ControlImplementation;

/**
 * User: APetrashkevich
 * Date: 18.03.13
 * Time: 16:09
 */
@ControlImplementation(isTransient = true)
public class HelloWorldImpl implements HelloWorld {

    public String hello() {
        return "hello!";
    }

    public String helloParam(String name) {
        return "Hello, " + name + "!";
    }
}