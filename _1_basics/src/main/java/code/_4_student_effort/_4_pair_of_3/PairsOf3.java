package code._4_student_effort._4_pair_of_3;

public class PairsOf3 {
    public static void main(String[] args) {
        Integer[] numbers = {-1, -1, -1, 2};
        System.out.println(countPairs(numbers));
    }

    private static Integer countPairs(Integer[] numbers) {
        Integer nrOfPairs = 0;
        Integer[] usedIndexes = new Integer[numbers.length];
        int nrOfUsedIndexes = 0;

        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    boolean areIndexesUsed = false;
                    for (int p = 0; p < nrOfUsedIndexes; p++) {
                        if (usedIndexes[p] == i || usedIndexes[p] == j || usedIndexes[p] == k) {
                            areIndexesUsed = true;
                            break;
                        }
                    }

                    if (!areIndexesUsed && (numbers[i] + numbers[j] + numbers[k] == 0)) {
                        usedIndexes[nrOfUsedIndexes++] = i;
                        usedIndexes[nrOfUsedIndexes++] = j;
                        usedIndexes[nrOfUsedIndexes++] = k;
                        nrOfPairs++;
                        System.out.println("(" + numbers[i] + ", " + numbers[j] + ", " + numbers[k] + ")");
                        break;
                    }
                }
            }
        }
        return nrOfPairs;
    }
}
