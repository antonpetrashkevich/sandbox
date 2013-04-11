/**
 * User: APetrashkevich
 * Date: 11.04.13
 * Time: 17:15
 */
public class ExcessiveCPURunnable implements Runnable {
    private static void excessiveCPU(int sum) {
        while (sum < Integer.MAX_VALUE / 10) {
            sum += 1;
            Math.sin(sum);
        }
    }

    @Override
    public void run() {
        int sum = 1;
        excessiveCPU(sum);
    }
}
