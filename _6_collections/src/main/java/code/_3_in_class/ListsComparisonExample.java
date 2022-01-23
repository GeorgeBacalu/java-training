package code._3_in_class;

import java.util.*;
import java.util.function.Consumer;

public class ListsComparisonExample {
    public static void main(String[] args) {
        List<Integer> elements = List.of(3, 5, 7, 1, 2, 9);
        List<Integer> list1 = new ArrayList<>(elements); // list1 poate stoca maxim Integer.MAX_VALUE elemente
        List<Integer> list2 = new LinkedList<>(elements); // list2 poate stoca oricate elemente incap in memorie (insa in momentul cand apelam diverse metode din interfata List
        // ce intorc int, acest numar va fi trunchiat la Integer.MAX_VALAUE)

        list1.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());

        System.out.println(list1);
        System.out.println(list2);

        List<Student> students = new ArrayList<>();
        students.add(new Student(20, 180, 9.90, 88.0, "Popescu", "Andrei"));
        students.add(new Student(19, 160, 6.90, 100.0, "Ionescu", "Mihai"));
        students.add(new Student(24, 165, 7.50, 75.0, "Anghelescu", "Constantin"));

        System.out.println("natural order");
        students.sort(Comparator.naturalOrder());
        System.out.println(students);

        System.out.println("by name");
        students.sort(Student.byName);
        System.out.println(students);

        System.out.println("by medie");
        students.sort(Student.byMedie);
        System.out.println(students + "\n");

        for(Student student : students) {
            System.out.println(student);
        }


        // !!! toate colectiile implementeaza design pattern-ul iterator
        // enhanced for reprezinta un sintactic sugar caruia i se face unwrap la compilare in
        // transformare:
        /*
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            // setul de instructiuni din for
            System.out.println(student); // cursorul este mereu plasat pe elementul de dinaintea celui analizat
        }
        */

        // imi pot defini o colectie care implementeaza interfata Itarable -> imi da un iterator
        MyListImplementation myListImplementation = new MyListImplementation();
        for(Object o : myListImplementation) {

        }
    }

    static class MyListImplementation implements Iterable {
        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public void forEach(Consumer action) {
            Iterable.super.forEach(action);
        }

        @Override
        public Spliterator spliterator() {
            return Iterable.super.spliterator();
        }
    }

    static class Student implements Comparable<Student> {
        private int varsta;
        private int inaltime;
        private double medieScolara;
        private double greutate;
        private String numeFamilie;
        private String prenume;

        static Comparator<Student> byName = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.numeFamilie.compareTo(student2.numeFamilie);
            }
        };

        static Comparator<Student> byMedie = new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.valueOf(student1.medieScolara).compareTo(student2.medieScolara);
            }
        };

        public Student(int varsta, int inaltime, double medieScolara, double greutate, String numeFamilie, String prenume) {
            this.varsta = varsta;
            this.inaltime = inaltime;
            this.medieScolara = medieScolara;
            this.greutate = greutate;
            this.numeFamilie = numeFamilie;
            this.prenume = prenume;
        }

        @Override
        public int compareTo(Student o) {
            return 0;
        }

        @Override
        public String toString() {
            return "Student{" + "varsta=" + varsta + ", inaltime=" + inaltime + ", medieScolara=" + medieScolara + ", greutate=" + greutate + ", numeFamilie='" + numeFamilie + '\'' + ", prenume='" + prenume + '\'' + '}';
        }
    }
}
