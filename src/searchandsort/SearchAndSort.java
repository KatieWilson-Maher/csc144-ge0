package searchandsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;


/**
 * @author katie
 * @version 3/26/20
 */
public class SearchAndSort {

    private static Random rng = new Random();
    private static final int SIZE_THRESHOLD = 12;

    public static List<Integer> makeList(int size) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int n = 10 + rng.nextInt(90);
            result.add(n);
        } // for

        return result;
    } // makeList( int )

    public static void printList(List<Integer> values) {
        if (values.size() < SIZE_THRESHOLD) {
            for (int n : values) {
                System.out.printf("%4d", n);
            } // for
            System.out.println();
        } // if
        else {
            for (int n : values) {
                System.out.printf("%4d\n", n);
            } // for
        } // else
    } // printList( List<Integer> )

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the sequential search algorithm.
    public static int linearSearch(List<Integer> values,
            int target) {
        int result = -1;

        int index = 0;
        while (index < values.size() && result < 0) {
            if (target == values.get(index)) {
                result = index;
            } // if
            index = index + 1;
        } // while
        return result;
    } // linearSearch( List<Integer>, int )

    // TO-DO: Define a method that determines
    // the index of the first integer in a list
    // of integers that matches a given integer.
    // The method should return -1 if no match is found.
    // Use the binary search algorithm.
    public static int binarySearch(List<Integer> values,
            int target) {
        int result = -1;

        int lo = 0;
        int hi = values.size() - 1;

        while (lo < hi && result < 0) {
            int mid = (lo + hi) / 2;
            if (target == values.get(lo)) {
                result = lo;
            } // if
            else if (target == values.get(mid)) {
                result = mid;
            } // else if
            else if (target == values.get(hi)) {
                result = hi;
            } // else if
            else if (target < values.get(mid)) {
                hi = mid - 1;
            } // else if
            else {
                lo = mid + 1;
            } // else
        } // while

        return result;
    } // binarySearch( List<Integer>, int )

    // TO-DO: Define a method that sorts a list
    // of integers using the selection sort algorithm.
    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    
    /**
    *Performs the Insertion Sort Method on an ArrayList
    * 
     * @param list an ArrayList to be sorted
    * @return ArrayList sorted
    */
    public static ArrayList insertionSort(ArrayList list){
        int size = list.size();
        for (int i = 0; i < size-1; i++){
            int min = (int) list.get(i);
            int next = (int) list.get(i+1);
            if (min>next){
                Collections.swap(list, i, i+1);
            }
        }
        return list;
    }
    /**
     * Splits an ArrayList into two ArrayLists
     * 
     * @param list ArrayList to be split
     * @return ArrayList split
     */
    public static ArrayList splitList(ArrayList list){
        int size = list.size();
        int firstHalf;
        int secondHalf;
        if (size%2 == 0){
            firstHalf = size/2;
            secondHalf = firstHalf;
        }
        else {
            firstHalf = size/2;
            secondHalf = firstHalf + 1;
        }
        ArrayList<Integer> firstHalfList = new ArrayList<>();
        for (int i = 0; i < firstHalf; i++){
            firstHalfList.add((Integer) list.get(i));
        }
        ArrayList<Integer> secondHalfList = new ArrayList<>();
        for (int i = firstHalf; i < size; i++){
            secondHalfList.add((Integer) list.get(i));
        }
        ArrayList<ArrayList> bothLists = new ArrayList<>();
        bothLists.add(firstHalfList);
        bothLists.add(secondHalfList);
        return bothLists;
    }
    
//    public static void mergeSort(ArrayList list){
//        int size = list.size();
//        ArrayList<ArrayList> elements = new ArrayList<>();
//        for (int i = 0; i<2; i++){
//            //System.out.println(list);
//            ArrayList split = splitList(list);
//            //System.out.println(split);
//           ArrayList newList = (ArrayList) split.get(i);
//           
//            //System.out.println(list);
//            split.remove(0);
//            size = newList.size();
//            //System.out.println(size);
//            //System.out.println(list);
//            elements.add(newList);
//            System.out.println("newList: "+newList);
//        }
//        
//        System.out.println("list: "+list);
//        System.out.println("elements: "+elements);
//    }
    
    public static void main(String[] args) {
       // System.out.println("Searching and sorting algorithms");

        // TO-DO: Add code that tests the searching and sorting
        // methods.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(25);
        list.add(5);
        list.add(20);
        list.add(40);

        System.out.println("insertionSort: "+insertionSort(list));

        System.out.println("splitList: "+splitList(list));
        
        ///mergeSort(list);
    } // main( String [] )
} // SearchAndSort
