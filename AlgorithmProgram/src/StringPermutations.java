/*******************************************************************************************************
 *
 * Purpose : Write static functions to return all permutations of a String using iterative method and
 *           Recursion method. Check if the arrays returned by two string functions are equal.
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 ******************************************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string : ");
        String str = scanner.next();
        String empty = "";
        int length = str.length();
        System.out.println("Possible Permutations of strings are :  ");

        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        arr1 = permutationsUsingIterativeMethod(arr1,str, empty);

        System.out.println("Using Recursion : ");
        arr2 = permutationUsingRecursion(arr2,str,0,length - 1);


        Collections.sort(arr1);
        Collections.sort(arr2);
        System.out.println(arr1);
        System.out.println(arr2);

        if(arr1.equals(arr2))
            System.out.println("Both Strings are equal");
        else
            System.out.println("Both of them are not equal ");
    }

    /**
     * Purpose : Getting all permutations using iterative method and storing permutations in arraylist
     *
     * @param arr1 arraylist to stored all permutations
     * @param str string taken from user
     * @param answer gets permutations
     * @return arraylist
     */
    public static ArrayList permutationsUsingIterativeMethod(ArrayList<String> arr1 ,String str, String answer) {

        int length = str.length();
        if (length == 0) {
            System.out.println(answer + " ");
            arr1.add(answer);
        }

        /*********************************************************************************************
         *
         * 1st iteration                    * 2nd iteration         * 3rd Iteration     * 4th iteration
         * length = 3-->rat                 * length = 2 --> at     * length  = 1--> t  * length = 0
         * let us take word : rat           *                       *                   *  length == 0
         * char ch will store : "r"         *char ch : a            *char ch : t        * print (answer)
         * leftStr will store nothing : ""  *leftStr : ""           *leftStr : ""       * "rat"
         * rightStr will store : "at"       *rightStr: "t"          *rightStr : ""      *
         * restStr will store : "at"        *restStr : "t"          *restStr : ""       *
         * answer will store : r            *answer : "ra"          *answer : "rat"     *
         ********************************************************************************************/
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            String leftStr = str.substring(0, i);
            String rightStr = str.substring(i + 1);
            String restStr = leftStr + rightStr;
            permutationsUsingIterativeMethod(arr1,restStr, answer + ch);
        }
        return arr1;
    }

    /**
     * Purpose : String Permutation using Recursion We are doing BackTracking here
     * @param arr2 arraylist to store permutations
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     * @return arraylist
     */
    public static ArrayList permutationUsingRecursion(ArrayList<String>arr2,String str, int l, int r) {
        if(l == r) {
            System.out.println(str);
            arr2.add(str);
        }
        else{
            for(int i = l; i <= r ; i++){
                str = swap(str,l,i);
                permutationUsingRecursion(arr2,str,l+1,r);
                str = swap(str,l,i);

            }
        }
        return arr2;
    }

    /**
     * Swap Characters at position
     * @param str a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[i];
        charArray[i] = temp;
        return String.valueOf(charArray);
    }
}
