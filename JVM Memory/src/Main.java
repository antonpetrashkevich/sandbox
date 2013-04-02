/**
 * User: APetrashkevich
 * Date: 02.04.13
 * Time: 11:10
 */
public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.println("Hello World");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
