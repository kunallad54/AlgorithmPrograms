/******************************************************************************************************
 *
 * Purpose : Binary Search the Word from Word List
 *           a. Desc -> Read in a list of words from File. Then prompt the user to enter a word to
 *                      search the list. The program reports if the search word is found in the list.
 *           b. I/P -> read in the list words comma separated from a File and then enter the word
 *                     to be searched
 *           c. Logic -> Use Arrays to sort the word list and then do the binary search
 *           d. O/P -> Print the result if the word is found or not
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 ******************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {

        BinarySearch bin = new BinarySearch();

        String filepath = "C:\\Users\\Kunal\\IdeaProjects\\AlgorithmPrograms\\src\\New Text Document.txt";

        // reading file
        Scanner scanner = new Scanner(new File(filepath));

        ArrayList<String> list = new ArrayList<String>();

        while (scanner.hasNext()) {
            // reading from file and adding to list
            list.add(scanner.next());

        }

        System.out.println("Before Sorting : \n" + list);
        // sorted the arraylist
        Collections.sort(list);
        System.out.println("\nAfter Sorting : \n" + list);

        System.out.println("\nEnter the word you want to search in string : ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        // Creating object for generics class to implement binary search
        BinarySearchImplementation<String> genericsBinary = new BinarySearchImplementation<>(list,word);

        Integer indexNumber = genericsBinary.binarySearchMethod();

        if (indexNumber == -1) {
            System.out.println("Word not found");
        } else {
            System.out.println("Word is present in the list  at index number : " + indexNumber);
        }
    }
}

/**
 * Purpose : To make generic class for binary search method
 * @param <T>
 */
class BinarySearchImplementation<T extends Comparable<T>>{
    //arraylist in which it will perform Binary Search
    ArrayList<T> tArrayList;

    // word that need to be searched in the list
    T word;
    public BinarySearchImplementation(ArrayList<T> tArrayList,T word) {
        this.tArrayList = tArrayList;
        this.word = word;
    }

    /**
     * Purpose : Here it performs binary Search :-
     *           1.Compares given value to be searched with middle element
     *           2.if matches return middle element
     *           3.if greater than middle skip left subArray and do same for rightArray
     *           4.if less than middle skip right subArray and do same for leftArray
     *           5.if not found returns -1
     *
     * @return index number if word found or -1 if not found
     */
    public int binarySearchMethod() {
        int left = 0, right = tArrayList.size() - 1;

        while (left <= right) {

            // getting mid element
            int mid = left + (right - left) / 2;

            // check if word is present at middle
            if (tArrayList.get(mid).equals(word))
                return mid;

            /**
             * if word to is greater than mid,ignore left half
             * and same if word is less than mid ignore right half
             */
            if (tArrayList.get(mid).compareTo(word) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // if word not found
        return -1;
    }
}
