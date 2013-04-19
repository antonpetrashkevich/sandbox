package memory;

/**
 * User: APetrashkevich
 * Date: 19.04.13
 * Time: 17:47
 */
public class MemoryLeakFactory {

    public static final int RANDOM_BYTES_NUMBER = 50;

    public static MemoryLeakBean randomMemoryLeakBean() {
        MemoryLeakBean memoryLeakBean = new MemoryLeakBean();
        for (int i = 0; i < MemoryLeakBean.BYTES_ARRAY_SIZE / RANDOM_BYTES_NUMBER; i++) {
            memoryLeakBean.insertRandomByte(RANDOM_BYTES_NUMBER);
        }

        return memoryLeakBean;
    }
}
