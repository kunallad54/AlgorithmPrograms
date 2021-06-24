import java.util.ArrayList;
import java.util.Scanner;

/********************************************************************************************
 *
 *  Purpose : Takes a range of 0 - 1000 or can take range from user Numbers
 *  and find the Prime numbers in that range and find the prime numbers
 *  that are Anagram and Palindrome
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 ********************************************************************************************/

public class PrimeNumbers {
    static PrimeNumbers pm = new PrimeNumbers();
    static Anagrams anagrams = new Anagrams();

    /**
     * Purpose : Main Method of class
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lower range : ");
        int lowerRange = scanner.nextInt();
        System.out.println("Enter the upper range : ");
        int upperRange = scanner.nextInt();

        ArrayList<Integer> totalPrimeNumbers = pm.primeNumbersInRange(lowerRange, upperRange);
        System.out.println("Prime Numbers are : \n" + totalPrimeNumbers);

        pm.isAnagramAndPalindrome(lowerRange, upperRange);
    }

    /**
     * Purpose : Check if number is prime by calling isPrime method and yes then adds in list
     * @param lowerRange  taken input from user
     * @param upperRange  taken input from user
     * @return arraylist of prime numbers
     */
    public ArrayList<Integer> primeNumbersInRange(int lowerRange, int upperRange) {
        ArrayList<Integer> listOfPrimeNumbers = new ArrayList();
        for (int i = lowerRange; i <= upperRange; i++) {
            if (pm.isPrime(i)) {
                listOfPrimeNumbers.add(i);
            }
        }
        return listOfPrimeNumbers;
    }

    /**
     * Purpose : Takes one number and compare that number with all numbers in range ,
     * if two numbers are not equal and are prime then it will check then both are anagrams
     * and palindrome if yes then prints those numbers
     *
     * @param lowerRange taken input from user
     * @param upperRange taken input from user
     */
    public void isAnagramAndPalindrome(int lowerRange, int upperRange) {
        for (int i = lowerRange; i <= upperRange; i++){
            if(pm.isPrime(i)){
                for(int j = i; j <= upperRange; j++){
                    if(i != j) {
                        if (isPrime(j)) {
                            if (anagrams.anagramChecker(String.valueOf(i).toCharArray(), String.valueOf(j).toCharArray()) && pm.isPalindrome(i)) {
                                System.out.println(i + " " + j + " are prime numbers and anagrams and palindrome");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Purpose : Checks whether number is prime number or not
     * @param i taken from calling function
     * @return true if number is prime or false
     */
    public boolean isPrime(int i) {
        if (i <= 1)
            return false;
        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

    /**
     * Purpose : Checks whether the number is Palindrome or not
     * @param number taken from calling function
     * @return true if palindrome else false
     */
    public boolean isPalindrome(int number){
        int reverse,sum = 0;
        int temp = number;
        while(number != 0)
        {
            reverse = number % 10;
            sum = sum * 10 + reverse;
            number /= 10;
        }
        if(temp == sum)
            return true;
        return false;
    }

}
