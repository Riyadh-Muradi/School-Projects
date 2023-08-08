import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-16")
public class SumTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() throws Throwable {
        // Create an ArrayList of numbers for testing
        ArrayList<Integer> numbers = numbers(3, 1, 7, 9, 2, 6);
        check(numbers);
    }

    @Test
    public void test2() throws Throwable {
        // Create an ArrayList of numbers for testing
        ArrayList<Integer> numbers = numbers(3, 1, 7, 9, 2, 6);
        check(numbers);
    }

    // Method to test the sum of numbers in an ArrayList
    private void check(ArrayList<Integer> numbers) throws Throwable {
        // Store the current standard output for comparison later
        String oldOut = io.getSysOut();
        
        // Invoke the 'sum' method using reflection
        int sum = Reflex.reflect(Sum.class).staticMethod("sum").returning(int.class).taking(ArrayList.class).invoke(numbers);

        // Replace the old standard output with the current output
        String out = io.getSysOut().replace(oldOut, "");

        // Calculate the expected sum using stream and mapToInt
        int expected = numbers.stream().mapToInt(i -> i).sum();

        // Compare the calculated sum with the returned sum
        assertEquals("When the sum method was called with this list: " + numbers + ", the sum should be " + expected + ". Your method returned " + sum, expected, sum);
    }

    // Method to create an ArrayList of integers from a variable-length argument list
    private static ArrayList<Integer> numbers(int... list) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i : list) {
            numbers.add(i);
        }
        return numbers;
    }
}
