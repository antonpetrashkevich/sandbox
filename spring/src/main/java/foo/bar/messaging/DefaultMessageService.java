package foo.bar.messaging;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * User: Anton
 * Date: 12.05.13
 * Time: 1:33
 */
public class DefaultMessageService implements MessageService, ApplicationContextAware, InitializingBean, DisposableBean {

    private String defaultMessage;
    private ApplicationContext context;


    @Qualifier("default")
    @Resource
    private String resourceString;


    @Qualifier("default")
    @Autowired
    private String autoMessage;

    public DefaultMessageService(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public void produceMessage() {
        System.out.println(defaultMessage);
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    public void init() {
        System.out.println("Default Message Service initialized;");
        System.out.println(autoMessage);

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Default Message Service destory;");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Default Message Service afterPropertiesSet;");
    }

    public void cleanUp() {
        System.out.println("Clean up " + context.getMessage("hello", null, "ERROR", null));
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("Default Message Service - POST CONSTRUCT");
    }


    @PreDestroy
    public void preDestroy() {
        System.out.println("Default Message Service - PRE DESTROY");
    }
}
