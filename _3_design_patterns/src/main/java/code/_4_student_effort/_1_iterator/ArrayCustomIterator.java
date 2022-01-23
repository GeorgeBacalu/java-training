package code._4_student_effort._1_iterator;

public class ArrayCustomIterator {
    private int[] arr;
    private int currentIndex;

    public ArrayCustomIterator(int[] arr) {
        this.arr = arr;
        this.currentIndex = 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        ArrayCustomIterator arrayIterator = new ArrayCustomIterator(arr);
        while(arrayIterator.hasNext()) System.out.print(arrayIterator.next() + " ");
    }

    private boolean hasNext() { return this.currentIndex < this.arr.length; }
    private int next() { return this.arr[this.currentIndex++]; }
}
