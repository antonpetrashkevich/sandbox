package memory;

import java.util.Random;

/**
 * User: APetrashkevich
 * Date: 19.04.13
 * Time: 17:46
 */
public class MemoryLeakBean {
    public static final int BYTES_ARRAY_SIZE = 50000;
    byte[] bytesArray = new byte[BYTES_ARRAY_SIZE];
    int insertIndex = 0;
    private Random random = new Random();

    public void insertRandomByte(int randomBytesNumber) {

        byte[] randomBytes = new byte[randomBytesNumber];
        random.nextBytes(randomBytes);
        for (int i = 0; i < randomBytes.length; i++) {
            if (insertIndex < BYTES_ARRAY_SIZE) {
                bytesArray[insertIndex++] = randomBytes[i];
            }
        }

    }
}
