package controls;

import org.apache.beehive.controls.api.bean.ControlInterface;

@ControlInterface
public interface HelloWorld {

    String hello();

    String helloParam(String name);
}