import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This file contains JUnit tests for some sample arithmetic
 * expressions. This file tests your program "as a whole", by
 * checking its printed output.
 *
 * YOU SHOULD NOT WRITE YOUR OWN TESTS THIS WAY, OR IN THIS FILE.
 * You should test the individual UNITS in your program, i.e., call
 * your add, multiply, and exponentiate methods and test their return
 * values.
 */
public class SampleTest {
    /**
     * The actual standard output stream.
     */
    private PrintStream old;

    /**
     * The streams we're using to capture printed output.
     */
    private ByteArrayOutputStream baos;

    /**
     * Gets called before each test method. Need to do this so that we can
     * capture the printed output from each method.
     */
    @BeforeEach
    public void setUp() {
        this.old = System.out; // Save a reference to the original stdout stream.
        this.baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    @Test
    public void testSampleFile() {
        BigNumArithmetic.main(new String[] { "SampleInput.txt" });
        String output = this.baos.toString();
        assertEquals("1 + 2 = 3\n" +
                "2 ^ 4 = 16\n" +
                "3 * 5 = 15\n" +
                "2 ^ 40 = 1099511627776", output);
    }

    @Test
    public void testAdd1() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add_to_list(5);
        list1.add_to_list(2);
        list2.add_to_list(3);
        list2.add_to_list(3);
        Addition addTest = new Addition();
        assertEquals(addTest.add(list1, list2), "85");
    }
    @Test
    public void testAdd2() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add_to_list(3);
        list2.add_to_list(1);
        list2.add_to_list(0);
        Addition addTest = new Addition();
        assertEquals(addTest.add(list1, list2), "13");
    }

    @Test
    public void testAdd3() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add_to_list(3);
        list1.add_to_list(1);
        list2.add_to_list(1);
        Addition addTest = new Addition();
        assertEquals(addTest.add(list1, list2), "32");
    }
    @Test
    public void testAdd4() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add_to_list(2);
        list1.add_to_list(0);
        list1.add_to_list(4);
        list2.add_to_list(6);
        list2.add_to_list(9);
        Addition addTest = new Addition();
        assertEquals(addTest.add(list1, list2), "273");
    }

    @Test
    public void testMult1(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        /** 1 * 24 **/
        list1.add_to_list(1);
        list2.add_to_list(2);
        Multiplication multTest = new Multiplication();
        assertEquals(multTest.multiplication(list1, list2), "2");
    }

    @Test
    public void testMult2(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        /** 1 * 24 **/
        list1.add_to_list(1);
        list2.add_to_list(2);
        list2.add_to_list(4);
        // right now it is doing (1 * 2) + (1 * 4) !!
        Multiplication multTest = new Multiplication();
        assertEquals(multTest.multiplication(list1, list2), "24");
    }

    @Test
    public void testMult3(){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.add_to_list(3);
        list2.add_to_list(4);
        // right now it is doing (1 * 2) + (1 * 4) !!
        Multiplication multTest = new Multiplication();
        assertEquals(multTest.multiplication(list1, list2), "12");
    }

    @Test
    public void testExpFile() {
        BigNumArithmetic.main(new String[] { "exponentTest.txt" });
        String output = this.baos.toString();
        assertEquals("21 ^ 10 = 16679880978201\n" +
                "2 ^ 40 = 1099511627776\n" +
                "3 ^ 9 = 19683\n" +
                "6 ^ 9 = 10077696", output);
    }

    @Test
    public void testaddFile() {
        BigNumArithmetic.main(new String[] { "additionTest.txt" });
        String output = this.baos.toString();
        assertEquals("1 + 2 = 3\n" +
                "2 + 4 = 6\n" +
                "10 + 20 = 30\n" +
                "204 + 69 = 273", output);
    }

    @Test
    public void testmultFile() {
        BigNumArithmetic.main(new String[] { "multTest.txt" });
        String output = this.baos.toString();
        assertEquals("3 * 4 = 21\n" +
                "41 * 2 = 28\n" +
                "41 * 21 = 861\n" +
                "8 * 71 = 541", output);
    }



    /**
     * Gets called after each test method. Need to do this so that we are
     * no longer capturing all printed output and printed stuff appears
     * like normal.
     */
    @AfterEach
    public void tearDown() {
        System.out.flush();
        System.setOut(this.old);
    }
}
