/****************************************************************************************************
 *
 * Purpose : Insertion Sort
 *           a. Desc -> Reads in strings and prints them in sorted order using insertion sort.
 *           b. I/P -> read in the list words
 *           c. Logic -> Use Insertion Sort to sort the words in the String array
 *           d. O/P -> Print the Sorted List
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 **************************************************************************************************/

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insert = new InsertionSort();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of string array : ");
        int size = scanner.nextInt();

        String[] str = new String[size];

        System.out.println("Enter "+size+" strings in array : ");
        for(int i = 0; i < size; i++){
            str[i] = scanner.next();
        }
        System.out.println("\nStrings in array are as follows : ");
        for(int i = 0; i < size; i++){
            System.out.print(str[i]+",");
        }
        String[] sortedString = insert.insertionSort(str);
        System.out.println();
        System.out.println("\nSorted String is as follows : ");
        for(int i = 0; i < size; i++){
            System.out.print(sortedString[i] + ",");
        }

    }

    /**
     * Purpose : To perform Insertion Sort :
     *          --> The array is virtually split into a sorted and an unsorted part.
     *          --> Values from the unsorted part are picked and placed at the correct position in the sorted part.
     *
     * @param str array which needs to be sorted
     * @return sorted string
     */
    public String[] insertionSort(String[] str){
        int size = str.length;
         for ( int i = 1; i < size; i++){
             String temp = str[i];
             int j = i - 1;
             /**
              * Move elements of arr[0..i-1], that are greater than temp, to one position ahead
              * of their current position
              */
             while (j >= 0 && str[j].compareTo(temp)>0){

                 str[j+1] = str[j];
                 j--;

             }
             str[j+1] = temp;
         }
         return str;
    }
}
