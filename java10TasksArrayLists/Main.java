package java10TasksArrayLists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //task 1
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("task 1");
        System.out.println(list);
        System.out.println("===========================");
        //task 2
        System.out.println("task 2");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        System.out.println(list2);
        list2.remove(3);
        System.out.println(list2);
        System.out.println("=======================================");

        //task 3
        System.out.println("task 3");

        String ch = "two";
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("one");
        list3.add("two");
        list3.add("three");

        if (list3.contains(ch)) {
            list3.indexOf(ch);
        } else {
            System.out.println("Элемента " + ch + " нет в списке");
        }
        System.out.println("====================================");

        //task 4
        System.out.println("task 4");

        ArrayList<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list4.add(i);
        }
        System.out.println(list4);

        for (int i = 0; i < list4.size(); i++) {
            list4.set(i, list4.get(i) + 2);
        }
        System.out.println(list4);
        System.out.println("======================================");

        //task 5
        System.out.println("task 5");

        ArrayList<String> stringList1 = new ArrayList<>();
        ArrayList<String> stringList2 = new ArrayList<>();

        stringList1.add("One");
        stringList1.add("Two");

        stringList2.add("three");
        stringList2.add("four");

        ArrayList<String> stringList3 = new ArrayList<>();

        stringList3.addAll(stringList1);
        stringList3.addAll(stringList2);

        System.out.println(stringList3);
        System.out.println("=========================================");

        //task 6
        System.out.println("task 6");

        ArrayList<String> list6 = new ArrayList<>();
        list6.add("abc");
        list6.add("cab");
        list6.add("bac");
        list6.add("acb");
        System.out.println(list6);
        for (int i = 0; i < list6.size(); i++) {
            if (list6.get(i).charAt(0) == 'a') {
                list6.remove(i);
            }
        }
        System.out.println(list6);
        System.out.println("============================");

        //task 7
        System.out.println("task 7");

        ArrayList<Integer> list7 = new ArrayList<>();
        list7.add(4);
        list7.add(7);
        list7.add(5);
        System.out.println(Collections.max(list7));

        System.out.println("===================================");

        //task 8
        System.out.println("task 8");

        ArrayList<Integer> list8 = new ArrayList<>();
        list8.add(1);
        list8.add(2);
        list8.add(2);
        list8.add(3);
        System.out.println(list8);

        Set<Integer> set = new HashSet<>(list8);
        list8.clear();
        list8.addAll(set);
        System.out.println(list8);
        System.out.println("==============================");

        //task 9
        System.out.println("task 9");

        ArrayList<String> list9 = new ArrayList<>();
        list9.add("b");
        list9.add("a");
        list9.add("d");
        list9.add("c");
        list9.add("g");
        System.out.println(list9);
        Collections.sort(list9);
        System.out.println(list9);
        System.out.println("===============================");

        //task 10
        System.out.println("task 10");

        ArrayList<String> list10 = new ArrayList<>();
        list10.add("a");
        list10.add("b");
        list10.add("c");
        list10.add("d");
        list10.add("e");
        System.out.println(list10);
        Collections.reverse(list10);
        System.out.println(list10);
    }
}
