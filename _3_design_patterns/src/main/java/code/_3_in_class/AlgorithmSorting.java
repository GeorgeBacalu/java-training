package code._3_in_class;

import java.util.List;

public abstract class AlgorithmSorting {

    // template method - design pattern
    public void sort(List<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                if(isCrescator(list.get(i), list.get(j))) {
                    int aux = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, aux);
                }
            }
        }
    }

    protected abstract boolean isCrescator(Integer integer, Integer integer1);
}
