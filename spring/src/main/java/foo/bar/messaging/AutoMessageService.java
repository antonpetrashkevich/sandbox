package foo.bar.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * User: Anton
 * Date: 12.05.13
 * Time: 16:02
 */

@Component
public class AutoMessageService implements MessageService, ApplicationListener<MessageEvent>, ApplicationEventPublisherAware {

    @Autowired
    private MessageSource messageSource;

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void produceMessage() {
    }

    public void init() {
        System.out.println("AUTO MESSAGE SERVICE - " + messageSource.getMessage("hello", null, "ERROR", null));
        applicationEventPublisher.publishEvent(new MessageEvent("There goes message event!!!"));
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println(event);
    }
}
