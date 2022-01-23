package code._1_study._1_contention;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ContentionExample {

    public static Lock lock = new ReentrantLock(true);
    public static final Object semafor = new Object();
    public static long v = 0;

    public static void main(String[] args) throws InterruptedException {
        long threadsNr = 5000;
        System.out.println(v); // linia 1
        // intre acestea se mai pot executa orice linii pe orice alt thread; liniile astea pot schimba valoarea lui v
        System.out.println(v); // linia 2
        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < threadsNr; i++) {
            list.add(new MyThread());
        }
        System.out.println("abc");

        //start all
        for (MyThread thread : list) {
            thread.start();
        }

        //wait for all
        for (MyThread thread : list) {
            thread.join();
        }

        System.out.println("Current value:  " + v);
        System.out.println("Supposed to be: " + 1_000_000L * threadsNr);
    }

}
