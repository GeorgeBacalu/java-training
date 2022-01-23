package code._0_activity;

public class GenericsActivity {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();

        Integer[] i = new Integer[]{3, 2, 6};
        Short[] s = new Short[]{3, 2, 6};
        Byte[] b = new Byte[]{3, 2, 6};
        Double[] d = new Double[]{3d, 2d, 6d};

        bubbleSort.sort(i);
        bubbleSort.sort(s);
        bubbleSort.sort(b);
        bubbleSort.sort(d);

        // var este introdus in java 11
        // var o = new Object[]{3, "abc", new Object()};
        // var o2 = m();
        // bubbleSort.sort(o); -> eroare: variabila de inferenta T are bound incompatibil (Comparable vs Object)
    }

    static class BubbleSort {
        public <T extends Comparable> void sort(T[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                for (int j = i + 1; j < list.length; j++) {
                    if (list[i].compareTo(list[j]) > 0) {
                        T temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
            }
        }
    }

    // T extends Comparable -> in contextul genericelor implementarea de interfete si extinderea de clase se face prin intermediul cuvantului extends

    public interface I1 {}
    public interface I2 {}
    public interface I3 extends I1, I2 {}
    public <T extends I1, I2> T m() { return null; }

    // folosind var se poate face infer la generice care extind interfete multiple
    // generice - tip de date care nu are clasa pe disc
    // in java masina virtuala nu are suport pentru generice (au pastrat varianta mai simpla) -> mai multa viteza la runtime
    // cei de la microsoft care au dezvoltat c# au ales sa implementeze generice in programul lor si din cauza codului in plus necesar pentru a le procesa este mai lent decat orice program care nu are generice la runtime
    // daca masina virtuala nu are suport pentru generice se verifica exista lor doar la compilare si dupa verificare sunt sterse la runtime (type erasure)
    // c++: template <=> generics

    // limitari: se leaga de liste si arraylists
}
