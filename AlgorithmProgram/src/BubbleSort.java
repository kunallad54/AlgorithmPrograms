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

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort bubble = new BubbleSort();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size the array : ");
        int size = scanner.nextInt();

        int[] arrayOfInt = new int[size];

        System.out.println("Enter " + size + " integer elements in array : ");
        for (int i = 0; i < size; i++) {

            arrayOfInt[i] = scanner.nextInt();

        }

        System.out.println("Array before bubble sort : ");
        for (int i = 0; i < size; i++) {

            System.out.print(arrayOfInt[i] + ",");

        }
        System.out.println();

        int[] sortedArrayInt = bubble.bubbleSort(arrayOfInt);
        System.out.println("Array after bubble sort : ");
        for (int i = 0; i < size; i++) {

            System.out.print(sortedArrayInt[i] + ",");

        }
    }

    /**
     *  Purpose : To perform bubble sort
     *            In bubble sort algorithm, array is traversed from first element to last element.
     *            Here, current element is compared with the next element.
     *            If current element is greater than the next element, it is swapped.
     *
     * @param arrayOfInt array that needs to be sorted
     * @return sorted array
     */
    private int[] bubbleSort(int[] arrayOfInt) {
        int sizeOfArray = arrayOfInt.length;

        for (int i = 0; i < sizeOfArray; i++) {

            for (int j = 1; j < sizeOfArray - i; j++) {

                if (arrayOfInt[j - 1] > arrayOfInt[j]) {
                    // swap elements
                    int temp = arrayOfInt[j - 1];
                    arrayOfInt[j - 1] = arrayOfInt[j];
                    arrayOfInt[j] = temp;

                }

            }

        }

        return arrayOfInt;
    }
}
