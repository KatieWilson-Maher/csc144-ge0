package searchandsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    // of integers using the insertion sort algorithm.
    // TO-DO: Define a method that sorts a list
    // of integers using the merge sort algorithm.
    public static void main(String[] args) {
        System.out.println("Searching and sorting algorithms");

        // TO-DO: Add code that tests the searching and sorting
        // methods.
    } // main( String [] )
} // SearchAndSort
