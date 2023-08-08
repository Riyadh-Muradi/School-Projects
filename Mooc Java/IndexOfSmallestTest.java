import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-11")
public class IndexOfSmallestTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method
    @Test
    public void test() {
        // Arrays of input numbers
        int[][] inputs = {
            {72, 2, 8, 8, 11, 9999},
            {72, 44, 8, 8, 11, 9999},
            {51, 22, -11, -140, -18, 9999},
            {1, 7, 9999},
            {3, 2, 9999},
            {-3, -2, -141, 22, 22, 7, 9999}
        };

        // Loop through each array of input numbers
        for (int i = 0; i < inputs.length; i++) {
            check(inputs[i]);
        }
    }

    // Helper method to check the index of the smallest number
    private void check(int... numbers) {
        int oldOut = io.getSysOut().length();

        // Set to store indices of the smallest number
        Set<Integer> indices = new HashSet<>();

        String in = "";
        int smallest = numbers[0];

        // Prepare input string and find the smallest number and its indices
        for (int i = 0; i < numbers.length - 1; i++) {
            in += numbers[i] + "\n";
            if (smallest > numbers[i]) {
                smallest = numbers[i];
                indices.clear();
                indices.add(i);
            }
        }

        // Append sentinel value to end the input
        in += "9999\n";

        // Set the prepared input
        io.setSysIn(in);

        // Call the main method of IndexOfSmallest class
        callMain(IndexOfSmallest.class);

        // Get the printed output after input
        String out = io.getSysOut().substring(oldOut);

        assertTrue("you're not printing anything!", out.length() > 0);

        // Validate that the smallest number is printed correctly
        assertTrue("The smallest number should be printed in the format: \"Smallest number: " + smallest + "\", where " + smallest + " is the smallest number.", out.contains("number: " + smallest));

        // Validate that indices of the smallest number are printed
        for (Integer index : indices) {
            assertTrue("All the indices of the smallest number should be printed. When the input was:\n" + in + "\nThe output was:\n" + out, out.contains("" + index));
        }
    }

    // Helper method to call the main method of a given class
    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Your program tried to read too much input. Remember to use nextLine() method to read!");
        } catch (Throwable e) {
            fail("Something unexpected happened. The public static void main(String[] args) method of '" + kl + "' class has disappeared \n"
            + "or something unexpected happened. More info: " + e);
        }
    }
}
