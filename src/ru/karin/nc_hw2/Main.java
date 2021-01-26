package ru.karin.nc_hw2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        checkList();
        compare_MyLinkedList_and_LinkedList(10000);
        compareCollections(10000, new ArrayList<>(), new LinkedList<>());
        compareCollections(10000, new HashSet<>(), new LinkedHashSet<>(), new TreeSet<>());
        compareMap(10000, new HashMap<Integer, Integer>(), new LinkedHashMap<Integer, Integer>(),
                new TreeMap<Integer, Integer>());
    }


    public static void compareCollections(int length, Collection<Integer>... collections) {
        System.out.println();
        System.out.print("Compare ");
        for (int i = 0; i < collections.length; i++)
            System.out.print(collections[i].getClass().getCanonicalName() + ", ");
        System.out.println();

        int[] testArray = new int[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = (int) Math.random() * 10000;
        }

        System.out.println("Add");
        for (int i = 0; i < collections.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                collections[i].add(testArray[j]);
            }
            long end = System.nanoTime();
            System.out.println(collections[i].getClass().getCanonicalName() + ": " + (end - start));
        }

        System.out.println("Search");
        for (int i = 0; i < collections.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                collections[i].contains(testArray[j]);
            }
            long end = System.nanoTime();
            System.out.print(collections[i].getClass().getCanonicalName() + ": ");
            System.out.printf("%,d\n", (end - start));
        }

        System.out.println("Remove");
        for (int i = 0; i < collections.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                collections[i].remove(testArray[(int) (testArray.length * Math.random())]);
            }
            long end = System.nanoTime();
            System.out.println(collections[i].getClass().getCanonicalName() + ": " + (end - start));
        }

        System.out.println("Insert");
        for (int i=0; i< collections.length; i++) {
            if (collections[i] instanceof List) {
                List atList = (List) collections[i];
                long start = System.nanoTime();
                for (int j = 0; j < length; j++) {
                    int randIndex= (int) (testArray.length * Math.random());
                    atList.add(testArray[randIndex], randIndex );
                }
                long end = System.nanoTime();
                System.out.println(collections[i].getClass().getCanonicalName() + ": " + (end - start));
            }
        }

        System.out.println("Get");
        for (int i=0; i< collections.length; i++) {
            if (collections[i] instanceof List) {
                List atList = (List) collections[i];
                long start = System.nanoTime();
                for (int j = 0; j < length; j++) {
                    int randIndex= (int) (testArray.length * Math.random());
                    atList.get(randIndex);
                }
                long end = System.nanoTime();
                System.out.println(collections[i].getClass().getCanonicalName() + ": " + (end - start));
            }
        }
    }

    public static void compareMap(int length, Map... maps) {
        System.out.println();
        System.out.print("Compare ");
        for (int i = 0; i < maps.length; i++)
            System.out.print(maps[i].getClass().getCanonicalName() + ", ");
        System.out.println();
        int[] testArray = new int[length];
        for (int i = 0; i < length; i++)
            testArray[i] = (int) Math.random() * 10000;

        System.out.println("Add");
        for (int i = 0; i < maps.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                maps[i].put(testArray[j], testArray[j]);
            }
            long end = System.nanoTime();
            System.out.println(maps[i].getClass().getCanonicalName() + ": " + (end - start));
        }

        System.out.println("Search");
        for (int i = 0; i < maps.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                maps[i].get(testArray[(int) (testArray.length * Math.random())]);
            }
            long end = System.nanoTime();
            System.out.println(maps[i].getClass().getCanonicalName() + ": " + (end - start));
        }

        System.out.println("Remove");
        for (int i = 0; i < maps.length; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < length; j++) {
                maps[i].remove(testArray[(int) (testArray.length * Math.random())]);
            }
            long end = System.nanoTime();
            System.out.println(maps[i].getClass().getCanonicalName() + ": " + (end - start));
        }

    }

    public static void checkList() {
        System.out.println("Check MyLinkedList");
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++)
            testList.add(i);
        System.out.println(testList);
        System.out.println("get 0 = " + testList.get(0));
        System.out.println("get 3 = " + testList.get(3));
        System.out.println("size = " + testList.size());
        System.out.println("indexof 5 = " + testList.indexOf(5));
        System.out.println("indexof 20 = " + testList.indexOf(20));
        System.out.println("set 12 at 6 " + testList.set(6, 12));
        System.out.println(testList);
        System.out.println("remove 6 " + testList.remove(6));
        System.out.println(testList);
        System.out.println("add 2 25");
        testList.add(2, 25);
        System.out.println(testList);
        System.out.println("set 4 15");
        testList.set(4, 15);
        System.out.println(testList);
        System.out.println("iterator");
        for (Integer elem : testList) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void compare_MyLinkedList_and_LinkedList(int length) {
        System.out.println();
        System.out.println("compare_MyLinkedList_and_LinkedList");
        System.out.println("length = " + length);
        MyLinkedList<Integer> myLL = new MyLinkedList<>();
        LinkedList<Integer> javaLL = new LinkedList<>();
        long startTime;
        long endTime;

        int[] testArray = new int[length];
        for (int i = 0; i < length; i++) {
            testArray[i] = (int) Math.random() * 10000;
        }

        //Add
        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            myLL.add(testArray[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Add in MyLinkedList = \t\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            javaLL.add(testArray[i]);
        }
        endTime = System.nanoTime();
        System.out.println("Add in Java LinkedList =\t\t " + (endTime - startTime));

        //insert
        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            myLL.add(testArray[i], (int)(Math.random() * myLL.size()));
        }
        endTime = System.nanoTime();
        System.out.println("Insert in MyLinkedList =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            javaLL.add(testArray[i], (int)(Math.random() * javaLL.size()));
        }
        endTime = System.nanoTime();
        System.out.println("Insert in Java LinkedList =\t\t " + (endTime - startTime));

        //remove
        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            myLL.remove((int) (Math.random() * myLL.size()));
        }
        endTime = System.nanoTime();
        System.out.println("Remove from MyLinkedList =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            javaLL.remove((int) (Math.random() * javaLL.size()));
        }
        endTime = System.nanoTime();
        System.out.println("Remove from Java LinkedList =\t " + (endTime - startTime));
    }
}