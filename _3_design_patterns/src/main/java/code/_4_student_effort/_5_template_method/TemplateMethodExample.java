package code._4_student_effort._5_template_method;

import java.util.Arrays;

public class TemplateMethodExample {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] firstCopy = Arrays.copyOf(arr, arr.length);
        Integer[] secondCopy = Arrays.copyOf(arr, arr.length);

        AscendingBubbleSort asc = new AscendingBubbleSort(); asc.sort(firstCopy);
        DescendingBubbleSort desc = new DescendingBubbleSort(); desc.sort(secondCopy);

        displaySorted(firstCopy);
        displaySorted(secondCopy);
    }

    private static void displaySorted(Integer[] arr) {
        for (Integer integer : arr) System.out.print(integer + " ");
        System.out.println();
    }
}
