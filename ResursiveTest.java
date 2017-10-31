package edu.gcccd.csis;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ResursiveTest {

    Recursive rTest = new Recursive();

    @Test
    public void testArray() {
        // Used for creating an output stream. printEveryOther prints and is void, so need to read what is printed for tests.
        ByteArrayOutputStream outTesting = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outTesting));

        // Test arrays
        int[] ta = {1,2,3,4,5,6,7,8,9,10};
        int[] powersOfTwo = {2,4,8,16,32,64,128,256,512,1024};
        int[] emptyArray = {};

        // Test with given example. Array of 1-10, printing every other 2
        rTest.printEveryOther(ta, 2);
        assertEquals("9753", outTesting.toString()) ;

        // Test with a null array
        outTesting.reset();
        rTest.printEveryOther(null,0);
        assertEquals("BAD INPUT", outTesting.toString()) ;

        // Test with a negative int for k
        outTesting.reset();
        rTest.printEveryOther(ta, -10);
        assertEquals("BAD INPUT", outTesting.toString()) ;

        // Test with an empty array
        outTesting.reset();
        rTest.printEveryOther(emptyArray, 2);
        assertEquals("", outTesting.toString()) ;

        // Additional test with different array
        outTesting.reset();
        rTest.printEveryOther(powersOfTwo, 4);
        assertEquals("51212832", outTesting.toString()) ;
    }

    @Test
    public void testString(){
        // Strings for testing
        String nullString = null;
        String helloString = "Hello";
        String testChars = "aabbccddabcd";
        String testNumAndChars = "aabb1134dddefghii";
        String testSingleChar = "a";

        // Assert tests
        // Test for null
        assertNull(rTest.printStars(nullString));
        // Test for Hello
        assertEquals("Hel*lo", rTest.printStars(helloString));
        // Test a bunch of characters
        assertEquals("a*ab*bc*cd*dabcd", rTest.printStars(testChars));
        // Test a bunch of characters and numbers
        assertEquals("a*ab*b1134d*d*defghi*i", rTest.printStars(testNumAndChars));
        // Test a single character
        assertEquals("a", rTest.printStars(testSingleChar));
    }

}
