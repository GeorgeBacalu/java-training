package code._3_in_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraySizeModificationExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
        String[] inputs = new String[0];
        String input;
        System.out.println("Enter your input strings: ");
        while(!(input = sc.next()).equalsIgnoreCase("exit")) {
            inputs = increaseSizeOfArray(inputs);
            inputs[inputs.length - 1] = input;
        }
        */

        List<String> inputs = new ArrayList<>();
        String input;
        System.out.println("Enter your input strings: ");
        while(!(input = sc.next()).equalsIgnoreCase("exit")) {
            inputs.add(input);
        }

        for(String s : inputs) System.out.print(s + ", ");
    }

    private static String[] increaseSizeOfArray(String[] inputs) {
        String[] increasedInputs = Arrays.copyOf(inputs, inputs.length + 1);
        String[] increasedInputs2 = new String[inputs.length + 1];
        System.arraycopy(inputs, 0, increasedInputs2, 0, inputs.length);
        return increasedInputs;
    }
}
