package code._3_in_class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlgorithmSortingDescending extends AlgorithmSorting {
    @Override
    protected boolean isCrescator(Integer i1, Integer i2) {
        return i1 < i2;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        AlgorithmSortingDescending s = new AlgorithmSortingDescending();
        s.sort(list);
        System.out.println(list);
    }
}
