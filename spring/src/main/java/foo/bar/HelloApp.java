package foo.bar;

import foo.bar.messaging.MessageService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

       /* HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());*/

        context.registerShutdownHook();

        MessageService messageService = (MessageService) context.getBean("defaultMessageService");
        messageService.produceMessage();

    }
}
