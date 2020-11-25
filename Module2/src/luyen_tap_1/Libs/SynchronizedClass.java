package luyen_tap_1.Libs;

public class SynchronizedClass {
    private int a = 0;

    public synchronized void log1(String msg1, String msg2) {

        for (int i = 1; i <= 5; i++) {
            a++;
            System.out.println(msg1 + "-" + msg2 + " > A: " + a);

            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
        }
    }

    public void log2(String msg1, String msg2) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                a++;
                System.out.println(msg1 + "-" + msg2 + " > A: " + a);

                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        }
    }
}
