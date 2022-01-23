package code._1_study._2_closure;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ClosureExample {
    public static void main(String[] args) {
        // cand o metoda este tratata ca o variabila si se paseaza ca argument catre alte functii, termenul folosit este cel de higher order function
        // functia helloFunction este inglobata in functia main
        // functia main actioneaza ca first class citizen in acest context

        final String hello = "Hello, ";
        Function<String, String> helloFunction = (name) -> hello + name; // functie = obiect
        // Function primeste ca parametrii tipurile de date de intrare si iesire

        Predicate<String> testPredicat = (String s) -> s.startsWith("A");
        // Predicate primeste ca parametru de intrare tipul dat si intoarce boolean

        Consumer<String[]> display1 = ClosureExample::displayCurrent;
        Consumer<String[]> display2 = ClosureExample::displayToUppercase;
        Consumer<String[]> display3 = ClosureExample::displayToLowercase;
        String[] arr = new String[]{"abc", "bCd", "cEf"};
        consumerManager(display1, arr);
        consumerManager(display2, arr);
        consumerManager(display3, arr);
        // consumer.accept(new String[]{"a", "b", "c"});
        // Consumer primeste ca intrare tipul de date oferit si intoarce void

        Supplier<LocalDate> supplier = () -> LocalDate.now();
        // Suplier nu primesc parametrii, dar intorc o valoare de tipul dat

        System.out.println(helloFunction.apply("John"));
        System.out.println(helloFunction.apply("Anastasia"));
    }

    public static void consumerManager(Consumer<String[]> consumer, String[] params) {
        consumer.accept(params);
    }

    public static void displayCurrent(String[] arr) {
        for(String element : arr) {
            System.out.println(element);
        }
    }

    public static void displayToUppercase(String[] arr) {
        for(String element : arr) {
            System.out.println(element.toUpperCase());
        }
    }

    public static void displayToLowercase(String[] arr) {
        for(String element : arr) {
            System.out.println(element.toLowerCase());
        }
    }
}
