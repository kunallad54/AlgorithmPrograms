/***********************************************************************************************
 *
 * Purpose : To check two strings are anagrams or not and accordingly print output
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 ************************************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {
    /**
     * Purpose : main method
     * @param args
     */
    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        Scanner scanner = new Scanner(System.in);

        char[] str1;
        char[] str2;

        System.out.println("Enter two Strings to compare : ");
        System.out.print("\nString 1 : ");
        str1 = scanner.next().toCharArray();
        System.out.print("\nString 2 : ");
        str2 = scanner.next().toCharArray();

        // checks if anagrams or not
        if(anagrams.anagramChecker(str1,str2))
            System.out.print("ANAGRAMS");
        else
            System.out.print("NOT ANAGRAMS");
    }

    /**
     * Purpose : To find whether two strings are anagrams or not
     *
     * @param str1 taken as input from user
     * @param str2 taken as input from user
     * @return true if are anagrams else falsse
     */
    public boolean anagramChecker(char[] str1, char[] str2) {

        int length1 = str1.length;
        int length2 = str2.length;

        if(length1 != length2)
            return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i = 0; i < length1; i++){

            if(str1[i] != str2[i])
                return false;

        }

        return true;
    }
}
