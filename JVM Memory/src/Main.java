import memory.ExcessiveMemoryRunnable;

/**
 * User: APetrashkevich
 * Date: 02.04.13
 * Time: 11:10
 */
public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        stressCPU();
        stressMemory();
        System.out.println("Time spent: " + (System.currentTimeMillis() - startTime));

    }

    private static void stressMemory() {
        Thread excessiveMemoryThread1 = new Thread(new ExcessiveMemoryRunnable());
        excessiveMemoryThread1.start();
        try {
            excessiveMemoryThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void stressCPU() {
        Thread excessiveCPUThread1 = new Thread(new ExcessiveCPURunnable());
        Thread excessiveCPUThread2 = new Thread(new ExcessiveCPURunnable());
        Thread excessiveCPUThread3 = new Thread(new ExcessiveCPURunnable());
        Thread excessiveCPUThread4 = new Thread(new ExcessiveCPURunnable());
        Thread excessiveCPUThread5 = new Thread(new ExcessiveCPURunnable());
        excessiveCPUThread1.start();
        excessiveCPUThread2.start();
        excessiveCPUThread3.start();
        excessiveCPUThread4.start();
        excessiveCPUThread5.start();


        try {
            excessiveCPUThread1.join();
            excessiveCPUThread2.join();
            excessiveCPUThread3.join();
            excessiveCPUThread4.join();
            excessiveCPUThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
