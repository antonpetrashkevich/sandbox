package foo.bar.messaging;

import org.springframework.context.ApplicationEvent;

/**
 * User: Anton
 * Date: 12.05.13
 * Time: 16:28
 */
public class MessageEvent extends ApplicationEvent {
    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the component that published the event (never <code>null</code>)
     */


    public MessageEvent(Object source) {
        super(source);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
