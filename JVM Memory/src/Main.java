/**
 * User: APetrashkevich
 * Date: 02.04.13
 * Time: 11:10
 */
public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        Thread excessiveCPUThread = new Thread(new ExcessiveCPURunnable());
        excessiveCPUThread.start();

        try {
            excessiveCPUThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));

    }


}
