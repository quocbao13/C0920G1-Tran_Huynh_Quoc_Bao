package _04_oop_in_java.exercise.stop_watch;

import java.time.Instant;
import java.util.Date;

public class StopWatch {
    private long startTime;
    private long stopTime;

    public long Start(){
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }

    public long Stop(){
        this.stopTime = System.currentTimeMillis();
        return this.startTime;
    }

    public long getElapsedTime() {
        return this.stopTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.Start();
        int a = 0;
        for (int x = 0; x < 100000000; x++) {
            for (int y = 0; y < 10000000; y++) {
                a += 1;
            }
        }
        System.out.println("aaa");
        stopWatch.Stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}
