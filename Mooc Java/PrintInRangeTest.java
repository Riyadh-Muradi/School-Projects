import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-15")
public class PrintInRangeTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() throws Throwable {
        // Generate a list of numbers
        ArrayList<Integer> numbers = numbers(3, 1, 7, 9, 2, 6);
        // Call the check method with specified lower and upper limits and the list of numbers
        check(1, 2, numbers, 1, 2);
    }

    @Test
    public void testi2() throws Throwable {
        // Generate a list of numbers
        ArrayList<Integer> numbers = numbers(3, 1, 7, 9, 2, 6);
        // Call the check method with different lower and upper limits and the list of numbers
        check(6, 999, numbers, 6, 7, 9);
    }

    private void check(int lower, int upper, ArrayList<Integer> numbers, int... expected) throws Throwable {
        // Store the original system output
        String oldOut = io.getSysOut();
        // Use Reflex to invoke the static method "printNumbersInRange" of PrintInRange class
        Reflex.reflect(PrintInRange.class).staticMethod("printNumbersInRange").returningVoid().taking(ArrayList.class, int.class, int.class).invoke(numbers, lower, upper);

        // Obtain the program's output, excluding the original system output
        String out = io.getSysOut().replace(oldOut, "");

        // Check if expected numbers are present in the output
        for (int i : expected) {
            assertTrue("When the 'printNumbersInRange' method was called with these numbers:\n" + numbers + "\n, lower limit " + lower + " and upper limit " + upper + "\nOutput should contain " + i + "\nOutput was:\n" + out, out.contains("" + i));
        }

        // Check if numbers not in the expected list are not present in the output
        NEXT:
        for (int num : numbers) {
            for (int exp : expected) {
                if (num == exp) {
                    continue NEXT;
                }
            }

            assertFalse("When 'printNumbersInRange' method was called with these numbers:\n" + numbers + "\n, lower limit " + lower + " and upper limit " + upper + "\nThe output was not expected to contain " + num + "\nOutput was:\n" + out, out.contains("" + num));
        }

    }

    // Helper method to generate an ArrayList of integers from an array of integers
    private static ArrayList<Integer> numbers(int... list) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i : list) {
            numbers.add(i);
        }
        return numbers;
    }
}
