package memory;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/**
 * User: APetrashkevich
 * Date: 19.04.13
 * Time: 17:44
 */
public class ExcessiveMemoryRunnable implements Runnable {

    Set<MemoryLeakBean> memoryConsumingMap = new HashSet<MemoryLeakBean>();

    @Override
    public void run() {
        int sum = 1;
        while (sum < Integer.MAX_VALUE / 10) {
            sum += 1;
            memoryConsumingMap.add(new WeakReference<MemoryLeakBean>(MemoryLeakFactory.randomMemoryLeakBean()).get());
            /*try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
