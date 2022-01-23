package code._4_student_effort._3_pair_of_2;

public class PairsOf2 {
    public static void main(String[] args) {
        Integer[] numbers = {3, 2, -3, -2, 3, 0};
        System.out.println(countPairs(numbers));
    }

    private static Integer countPairs(Integer[] numbers) {
        Integer nrOfPairs = 0;
        Integer[] usedIndexes = new Integer[numbers.length];
        int nrOfUsedIndexes = 0;

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                boolean areIndexesUsed = false;
                for(int k = 0; k < nrOfUsedIndexes; k++) {
                    if (usedIndexes[k] == i || usedIndexes[k] == j) {
                        areIndexesUsed = true;
                        break;
                    }
                }
                if(!areIndexesUsed && (numbers[i] + numbers[j] == 0)) {
                    usedIndexes[nrOfUsedIndexes++] = i;
                    usedIndexes[nrOfUsedIndexes++] = j;
                    nrOfPairs++;
                    System.out.println("(" + numbers[i] + ", " + numbers[j] + ")");
                    break;
                }
            }
        }
        return nrOfPairs;
    }
}
