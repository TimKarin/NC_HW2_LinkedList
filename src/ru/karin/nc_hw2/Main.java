package ru.karin.nc_hw2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //checkList();
        compare_MyLinkedList_and_LinkedList(10000);
        compare_ArrayList_and_LinkedList(10000);
        compare_HashSet_and_LinkeHashSet_and_TreeSet(1000);
        compare_HashMap_and_LinkeHasMap_and_TreeMap(10000);


    }

    public static void checkList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i=0; i<10; i++)
            testList.add(i);
        System.out.println(testList);
        System.out.println ("get 0 = " + testList.get(0));
        System.out.println ("get 3 = " + testList.get(3));
        System.out.println("size = " + testList.size());
        System.out.println ("indexof 5 = " + testList.indexOf(5));
        System.out.println ("indexof 20 = " + testList.indexOf(20));
        System.out.println ("set 12 at 6 " + testList.set(6, 12));
        System.out.println (testList);
        System.out.println ("remove 6 " + testList.remove(6));
        System.out.println (testList);
        System.out.println ("add 2 25");
        testList.add(2, 25);
        System.out.println (testList);
        System.out.println ("set 4 15");
        testList.set(4, 15);
        System.out.println (testList);
        System.out.println ("iterator");
        for(Integer elem: testList) {
            System.out.print(elem + " ");
        }
    }

    public static void compare_MyLinkedList_and_LinkedList(int length) {
        System.out.println();
        System.out.println("compare_MyLinkedList_and_LinkedList");
        System.out.println("length = " + length);
        MyLinkedList<Integer> myLL = new MyLinkedList<>();
        LinkedList<Integer> javaLL = new LinkedList<>();
        long startTime;
        long endTime;

        //Add
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            myLL.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in MyLinkedList = \t\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            javaLL.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in Java LinkedList =\t\t " + (endTime - startTime));

        //insert
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            myLL.add((int)Math.random()%length, i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert in MyLinkedList =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            javaLL.add((int)Math.random()%length, i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert in Java LinkedList =\t\t " + (endTime - startTime));

        //remove
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            myLL.remove((int)Math.random()%length);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from MyLinkedList =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            javaLL.remove((int)Math.random()%length);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from Java LinkedList =\t " + (endTime - startTime));
    }

    public static void compare_ArrayList_and_LinkedList(int length) {
        System.out.println();
        System.out.println("compare_ArrayList_and_LinkedList");
        System.out.println("length = " + length);
        ArrayList<Integer> arrList = new ArrayList<>();
        LinkedList<Integer> linkList = new LinkedList<>();
        long startTime;
        long endTime;

        //Add
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            arrList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in ArrayList =\t\t\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            linkList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in LinkedList = \t\t" + (endTime - startTime));

        //Insert
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            arrList.add((int)Math.random()%length, i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert into ArrayList =\t\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            linkList.add((int)Math.random()%length, i);
        }
        endTime = System.nanoTime();
        System.out.println("Insert into LinkedList = \t" + (endTime - startTime));

        //Remove
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            arrList.remove((int)Math.random()%length);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from ArrayList = \t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            linkList.remove((int)Math.random()%length);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from LinkedList = \t" + (endTime - startTime));
    }

    public static void compare_HashSet_and_LinkeHashSet_and_TreeSet(int length) {
        System.out.println();
        System.out.println("compare_HashSet_and_LinkeHashSet_and_TreeSet");
        System.out.println("length = " + length);

        HashSet<Integer> hSet = new HashSet<>();
        LinkedHashSet lSet = new LinkedHashSet();
        TreeSet tSet = new TreeSet();

        long startTime;
        long endTime;

        //Add
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            hSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in HashSet =\t\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            lSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in LinkedHashSet =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            tSet.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("Add in TreeSet =\t\t\t " + (endTime - startTime));

        //Remove
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            hSet.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from HashSet =\t\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            lSet.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from LinkedHashSet =\t " + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            tSet.remove(i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from TreeSet =\t\t " + (endTime - startTime));

    }

    public static void compare_HashMap_and_LinkeHasMap_and_TreeMap(int length) {
        System.out.println();
        System.out.println("compare_HashMap_and_LinkeHasMap_and_TreeMap");
        System.out.println("length = " + length);

        HashMap<Integer, Integer> hMap = new HashMap<>();
        LinkedHashMap lMap = new LinkedHashMap();
        TreeMap tMap = new TreeMap();

        long startTime;
        long endTime;

        //Add
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            hMap.put(i, i+1000);
        }
        endTime = System.nanoTime();
        System.out.println("Add in HashMap = \t\t\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            lMap.put(i, i+1000);
        }
        endTime = System.nanoTime();
        System.out.println("Add in LinkedHashMap = \t\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            tMap.put(i, i+1000);
        }
        endTime = System.nanoTime();
        System.out.println("Add in TreeMap =\t\t\t" + (endTime - startTime));

        //Remove
        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            hMap.remove(1000-i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from HashMap = \t\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            lMap.remove(1000-i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from LinkedHashMap =\t" + (endTime - startTime));

        startTime = System.nanoTime();
        for (int i=0; i<length; i++) {
            tMap.remove(1000-i);
        }
        endTime = System.nanoTime();
        System.out.println("Remove from TreeMap = \t\t" + (endTime - startTime));
    }
}
