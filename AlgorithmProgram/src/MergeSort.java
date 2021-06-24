/***************************************************************************************************************
 * Purpose : Merge Sort - Write a program to do Merge Sort of list of Strings.
 *           a. Logic -> To Merge Sort an array, we divide it into two halves, sort the two halves
 *                       independently, and then merge the results to sort the full array. To sort a[lo, hi),
 *                       we use the following recursive strategy:
 *           b. Base case: If the subarray length is 0 or 1, it is already sorted.
 *           c. Reduction step: Otherwise, compute mid = lo + (hi - lo) / 2, recursively sort the
 *              two subarrays a[lo, mid) and a[mid, hi), and merge them to produce a sorted
 *              result.
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 ***************************************************************************************************************/

import java.util.Scanner;

public class MergeSort {

    static MergeSort merge = new MergeSort();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int size = scanner.nextInt();

        int[] arrayOfInt = new int[size];
        System.out.println("Enter " + size + " integer elements in array : ");
        for (int i = 0; i < size; i++) {
            arrayOfInt[i] = scanner.nextInt();
        }
        int lowerBound = 0;
        int upperBound = size - 1;
        merge.sort(arrayOfInt, lowerBound, upperBound);
        System.out.println("Sorted array is : ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayOfInt[i] + ",");
        }
    }

    /**Purpose : To perform merge sort
     *          Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves,
     *          calls itself for the two halves, and then merges the two sorted halves. The merge() function is
     *          used for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m]
     *          and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one
     *
     *
     * @param arrayOfInt array that needs to be sorted
     * @param lowerBound start Index
     * @param upperBound end Index
     */
    private void sort(int[] arrayOfInt, int lowerBound, int upperBound) {
        int mid;
        if (lowerBound < upperBound) {
            // find the middle element
            mid = (lowerBound + upperBound) / 2;

            // Sorts first and second Halves
            sort(arrayOfInt, lowerBound, mid);
            sort(arrayOfInt, mid + 1, upperBound);

            //Merges the sorted halves
            merge.mergeSort(arrayOfInt, lowerBound, mid, upperBound);
        }

    }

    /**
     * Purpose : Merges two subArrays of arrayInt
     *           First subArray[lowerBound...Mid]
     *           Second subArray[Mid+1...UpperBound]
     *
     * @param arrayOfInt
     * @param lowerBound
     * @param mid
     * @param upperBound
     */
    private void mergeSort(int[] arrayOfInt, int lowerBound, int mid, int upperBound) {

        // finds sizes of two subArrays that needs to be merged
        int l = mid - lowerBound + 1;
        int r = upperBound - mid;

        // Creates temporary arrays
        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        //Copying data to temp Arrays
        for (int i = 0; i < l; i++) {
            leftArray[i] = arrayOfInt[lowerBound + i];
        }

        for (int j = 0; j < r; j++) {
            rightArray[j] = arrayOfInt[mid + 1 + j];
        }

        // Merge the temp Arrays

        // Initial Indexing of first and second subArrays
        int i = 0, j = 0;

        //Initial Index of merge subArray
        int k = lowerBound;


        while (i < l && j < r) {

            if (leftArray[i] < rightArray[j]) {

                arrayOfInt[k] = leftArray[i];
                i++;

            } else {

                arrayOfInt[k] = rightArray[j];
                j++;

            }

            k++;
        }

        // Copy remaining elements of leftArray if left any
        while (i < l) {

            arrayOfInt[k] = leftArray[i];
            i++;
            k++;

        }

        // Copy remaining elements of rightArray if left any
        while (j < r) {

            arrayOfInt[k] = rightArray[j];
            j++;
            k++;

        }

    }
}
