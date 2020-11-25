package luyen_tap_1.Views;

import luyen_tap_1.Libs.NumberN;
import luyen_tap_1.Libs.SynchronizedClass;

public class NumberNTest {
    public static void main(String[] args) {
//        NumberN.searchN();
//        NumberN.searchString();
        SynchronizedClass obj1 = new SynchronizedClass();

        Thread t1 = new Thread() {
            public void run() {
                obj1.log1("Thread 1", "Log 1");
                // obj1.log2("Thread 1", "Log 2");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                obj1.log1("Thread 2", "Log 1");
                // obj1.log2("Thread 2", "Log 2");
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                obj1.log1("Thread 3", "Log 1");
                // obj1.log2("Thread 3", "Log 2");
            }
        };

        Thread t4 = new Thread() {
            public void run() {
                obj1.log1("Thread 4", "Log 1");
                // obj1.log2("Thread 3", "Log 2");
            }
        };

        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}
