package code._4_student_effort._2_strategy;

import java.util.Arrays;

public class MergeSort implements SortingStrategy {

    @Override
    public void sort(Integer[] list) {
        if(list.length < 2) return;
        int middle = list.length / 2;
        Integer[] left = Arrays.copyOfRange(list, 0, middle);
        Integer[] right = Arrays.copyOfRange(list, middle, list.length);

        sort(left);
        sort(right);
        merge(left, right, list);
    }

    private void merge(Integer[] left, Integer[] right, Integer[] list) {
        int leftIndex = 0, rightIndex = 0, listIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex].compareTo(right[rightIndex]) < 0) {
                list[listIndex++] = left[leftIndex++];
            } else {
                list[listIndex++] = right[rightIndex++];
            }
        }
        while(leftIndex < left.length) list[listIndex++] = left[leftIndex++];
        while(rightIndex < right.length) list[listIndex++] = right[rightIndex++];
    }
}
