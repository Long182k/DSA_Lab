package list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        demo(list);
    }

    public static void demo(List<Integer> list) {
        //        List Iterator method

        System.out.println("-----------List Iterator method-----------");

        for (int idx = 0; idx < 10; idx++) {
            list.add(idx);
        }

        ListIterator<Integer> listIterator = list.listIterator();
        System.out.print("Before modification: ");
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            int item = listIterator.next();
            if (item % 2 == 0) {
                listIterator.set(item * 10);
            } else {
                listIterator.remove();
            }
        }

        listIterator = list.listIterator();
        System.out.print("After modification: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

//        List Index method
        System.out.println("------------List Index method-------------");

        list.clear();
        for (int idx = 0; idx < 10; idx++) {
            list.add(idx);
        }

        listIterator = list.listIterator();
        System.out.print("Before modification: ");
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

        for (int idx = 0; idx < list.size(); idx++) {
            int item = list.get(idx);
            if (item % 2 == 0) {
                list.set(idx, item * 10);
            } else {
                list.remove(idx);
                idx -= 1;
            }
        }

        listIterator = list.listIterator();
        System.out.print("After modification: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
    }
}
