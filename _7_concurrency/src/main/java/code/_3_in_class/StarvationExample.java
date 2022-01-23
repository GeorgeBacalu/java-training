package code._3_in_class;

public class StarvationExample {
    public static Object o = new Object(); // cand incepem executia functia main, aceasta incepe fara a crea un obiect Main si daca noi avem
    // functia main statica, trebuie sa creem un obiect static in exterior pentru a ne putea folosi de el

    public static void main(String[] args) throws InterruptedException {
        OtherThread otherThread = new OtherThread("The other thread");
        otherThread.start();
        otherThread.join(); // main thread suspenda executia sa la linia asta de cod, pana cand otherThread isi termina executia
        synchronized (o) {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Hello from the main thread " + i);
            }
        }
    }

    static class OtherThread extends Thread {
        public OtherThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                synchronized (o) {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println("Hello from the other thread " + i);
                    }
                }
                while(true) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}