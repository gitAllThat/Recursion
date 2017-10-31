package edu.gcccd.csis;

import com.sun.deploy.util.ArrayUtil;

public class Recursive {
    /*
    * recursive method to output every other element in the given array backwards,
    * ending with the element at index k.
    * An example input arrary {1,2,3,4,5,6,7,8,9,10}, called with k=2, should output 9753
    */
    public static void printEveryOther(final int[] ia, final int k) {
        if (ia == null || k < 0) // Test to see if array is null
        {
            System.out.print("BAD INPUT");
            return;
        }
        int arrayPrintBegin = ia.length - 2; // Find where to begin printing, every other element so -2 of length
        if (ia.length > k && k >= 0) // Make sure ia length is greater than k, and that k isn't 0 so no index errors and recursion check
        {
            System.out.print(ia[arrayPrintBegin]);
            int[] newIA = new int[arrayPrintBegin]; // Create new array with -2 length
            for (int i = 0; i < newIA.length; i++) // populate array
            {
                newIA[i] = ia[i];
            }
            printEveryOther(newIA,k); // recursively call method again.
        }
    }

    /*
    * recursively take in a string and place a * between adjacent letters that are the same
    * An example input String "hello" should return hel*lo.
    */
    static int test;
    public static String printStars(final String s) {

        if (s == null){return  null;} // Check for nulls, return a null if so.

        if (s.length() <= 1){return s;} // Make sure the length is greater than one before returning. Also ends recursion.

        String tempBuild = ""; // Temp string for holding characters as recursion happens

        if (s.charAt(0)  == s.charAt(1)) // Check if the two characters are equal
        {
            if (Character.isLetter(s.charAt(0)) == true) // Check that the characters are letters
            {
                tempBuild += s.charAt(0) + "*"; // If so, add character and * to temp string
            }
            else
            {
                tempBuild += s.charAt(0); // They are equal but not letters, so just add character
            }
        }
        else
        {
            tempBuild += s.charAt(0); // first two characters are not equal, just add the first char to the temp string
        }

        tempBuild += printStars(s.substring(1,s.length())); // recursively run through the string without the first letter.
        /* Will do the following with the example of Hello:
        "H"+= printStars("ello");
        "H"+"e"+= printStars("llo");
        "H"+"e"+"l*"+= printStars("lo");
        "H"+"e"+"l*"+"l"+= printStars("o");
            Then, because the string is only one char, will end recursion and build the full string of Hel*lo and return it.
         */
        return tempBuild;
    }

    public static void main(String[] args) {
        printEveryOther(new int[]{1,2,3,4,5,6,7,8,9,10}, 2);
        System.out.println(printStars("Hello"));
    }
}