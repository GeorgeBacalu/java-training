package code._4_student_effort._2_strategy;

import java.util.Arrays;

public class StrategyExample {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] firstCopy = Arrays.copyOf(arr, arr.length);
        Integer[] secondCopy = Arrays.copyOf(arr, arr.length);
        displaySorted(new BubbleSort(), firstCopy);
        displaySorted(new MergeSort(), secondCopy);
    }

    private static void displaySorted(SortingStrategy strategy, Integer[] arr) {
        strategy.sort(arr);
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
