package code._3_in_class;

public class DeadlockExample {
    public static Object o1 = new Object();
    public static Object o2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            OtherThread t1 = new OtherThread("T1", o1, o2);
            OtherThread t2 = new OtherThread("T2", o2, o1);

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    static class OtherThread extends Thread {
        private Object firstResource;
        private Object secondResource;

        public OtherThread(String name, Object firstResource, Object secondResource) {
            super(name);
            this.firstResource = firstResource;
            this.secondResource = secondResource;
        }

        @Override
        public void run() {
            try {
                synchronized (firstResource) {
                    Thread.sleep(1000);
                    synchronized (secondResource) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
