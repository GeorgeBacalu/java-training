package code._3_in_class;

import java.time.Duration;
import java.time.Instant;

public class SlowLoops {
    public static void main(String[] args) {
        loopUsingPrimitive();
        loopUsingWrapper();
    }

    private static void loopUsingWrapper() {
        Instant start = Instant.now();
        for(Integer i = 0; i < 10000000; i++);
        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        System.out.println("Using wrapper: " + duration);
    }

    private static void loopUsingPrimitive() {
        Instant start = Instant.now();
        for(int i = 0; i < 10000000; i++);
        Instant stop = Instant.now();
        Duration duration = Duration.between(start, stop);
        System.out.println("Using primitive: " + duration);
    }
}
