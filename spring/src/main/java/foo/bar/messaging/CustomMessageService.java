package foo.bar.messaging;

import java.util.List;
import java.util.Random;

/**
 * User: Anton
 * Date: 12.05.13
 * Time: 1:34
 */
public class CustomMessageService implements MessageService {

    private List<String> customMessages;


    @Override
    public void produceMessage() {
        System.out.println(customMessages.get(Math.abs(new Random().nextInt() % customMessages.size())));
    }

    public void setCustomMessages(List<String> customMessages) {
        this.customMessages = customMessages;
    }

    public void cleanUp() {
        System.out.println("Yet another clean up..");
    }

    public void init() {
        System.out.println("Yet another init..");
    }
}
