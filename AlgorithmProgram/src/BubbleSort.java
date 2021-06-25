/***************************************************************************************************
 *
 * Purpose : Bubble Sort
 *          a. Desc -> Reads in integers prints them in sorted order using Bubble Sort
 *          b. I/P -> read in the list ints
 *          c. O/P -> Print the Sorted List
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 **************************************************************************************************/

import java.util.Scanner;

public class  BubbleSort{

    /**
     * Purpose : Main Method of Class
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size the array : ");
        int size = scanner.nextInt();

        Integer[] arrayOfInt = new Integer[size];

        System.out.println("Enter " + size + " integer elements in array : ");
        for (int i = 0; i < size; i++) {

            arrayOfInt[i] = scanner.nextInt();

        }


        System.out.println("Array before bubble sort : ");
        for (int i = 0; i < size; i++) {

            System.out.print(arrayOfInt[i] + ",");

        }

        BubbleSortImplementation<Integer> generics = new BubbleSortImplementation<Integer>(arrayOfInt);

        System.out.println();
        Integer[] sortedArrayInt = generics.bubbleSort();
        System.out.println("Array after bubble sort : ");
        for (int i = 0; i < size; i++) {

            System.out.print(sortedArrayInt[i] + ",");

        }
    }
}

/**
 * Purpose : Generics class  to implement bubble sort in generics method
 * @param <T>
 */
class BubbleSortImplementation<T extends Comparable<T>>{

    //array that needs to be sorted
    T [] arrayElements;

    /**
     *  Purpose : To perform bubble sort
     *            In bubble sort algorithm, array is traversed from first element to last element.
     *            Here, current element is compared with the next element.
     *            If current element is greater than the next element, it is swapped.
     *
     * @return sorted array
     */

    public BubbleSortImplementation(T[] arrayElements) {
        this.arrayElements = arrayElements;
    }
    public T[] bubbleSort() {
        int sizeOfArray = arrayElements.length;

        for (int i = 0; i < sizeOfArray; i++) {

            for (int j = 1; j < sizeOfArray - i; j++) {

                if (arrayElements[j - 1].compareTo(arrayElements[j])> 0) {
                    // swap elements
                    T temp = arrayElements[j - 1];
                    arrayElements[j - 1] = arrayElements[j];
                    arrayElements[j] = temp;

                }

            }

        }

        return arrayElements;
    }
}
