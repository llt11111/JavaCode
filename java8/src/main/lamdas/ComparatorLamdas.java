package main.lamdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorLamdas {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(1, 2)) ;


        Comparator<Integer> comparatorLamda = Comparator.naturalOrder();
        System.out.println(comparatorLamda.reversed().compare(1, 2)) ;

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(0);
        list.sort(Comparator.reverseOrder());
        System.out.println(
                list.toString()
        );

        list.sort(comparatorLamda);
        System.out.println(list.toString());
    }
}
