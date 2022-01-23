package code._1_study._1_checked_list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        // myList.add(LocalDate.now());
        // myList.add(List.of(1, 2, 3));

        int sum = 0;
        for(Object o : myList) {
            if(o instanceof Integer) {
                sum += (Integer) o;
            }
        }

        List chkList = Collections.checkedList(myList, String.class);
        System.out.println("Checked list content: " + chkList);

        //you can add any type of elements to myList object
        // myList.add(10);
        //you cannot add any type of elements to chkList object
        // chkList.add(10); //throws ClassCastException, because it checks the element's type

        // breakAList(myList);

        for(String s : myList) {
            System.out.println(s);
        }
        
        m(List.of(1, 2));
    }

    private static void breakAList(List<String> myList) {
        List listOfObjects = myList;
        listOfObjects.add(LocalDate.now());
        // heap pollution apare atunci cand incercam sa adaugam tipuri de date diverse intr-un ArrayList care merge dupa principiul array
        // listOfObjects pointeaza catre aceeasi zona de memorie ca si myList -> incercand sa adaug elemente in listOfObjects, se incearca adaugarea lor si in myList
        // -> se arunca exceptie daca tipul elementului adaugat nu coincide cu cel dorit pentru lista myList
    }

    private static <E> void m(List<E> list) {
        // din moment ce genericele sunt eliminate la runtime prin type erasure, in momentul executiei nu mai cunosc tipul de date E din apelul functiei, astfel ca trebuie sa verific zona de memorie alocata si verific contra tipuri de date diferite
        E element = list.get(0);
        if(element instanceof String) System.out.println("Este o lista de String");
        else if(element instanceof Integer) System.out.println("Este o lista de Integer");
    }
}
