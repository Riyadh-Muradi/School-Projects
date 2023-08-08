import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-13")
public class AverageOfAListTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method
    @Test
    public void test() {
        // Arrays of numbers to be tested
        int[][] inputs = {{5, 22, -11, -140, -18}, {1}, {3, 2, 1}, {-3, -2, -141}};

        // Loop through each array of numbers
        for (int i = 0; i < inputs.length; i++) {
            check(inputs[i]);
        }
    }

    // Helper method to check average calculation and output
    private void check(int... numbers) {
        int oldOut = io.getSysOut().length();

        // Prepare input string and calculate sum
        String in = "";
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            in += numbers[i] + "\n";
            sum += numbers[i];
        }

        // Add -1 as a sentinel value to end the input
        in += "-1\n";

        // Set the prepared input
        io.setSysIn(in);

        // Call the main method of AverageOfAList class
        callMain(AverageOfAList.class);

        // Get the printed output after input
        String out = io.getSysOut().substring(oldOut);

        assertTrue("you're not printing anything!", out.length() > 0);

        // Calculate the expected average
        double expectedResult = (1.0 * sum / numbers.length);

        // Extract the actual average value from the output
        double result = getLastNumber(out);

        // Prepare an error message for assertion
        String errorMsg = "Input:\n" + in + "\n\n Expected: \"" + expectedResult + "\", you printed: \"" + result + "\"\n";

        // Compare the expected and actual averages with a tolerance of 0.001
        assertEquals(errorMsg, expectedResult, result, 0.001);
    }

    // Helper method to call the main method of a given class
    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String[] t = null;
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

    // Helper method to extract the last number from a string
    private static double getLastNumber(String inputStr) {
        // Define a pattern to match the last number in the output string
        String patternStr = "(?s).*?(-?\\d+\\.\\d+)\\s*$";

        // Create a matcher to search for the pattern in the input string
        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        // Assert that the pattern is found in the output string
        assertTrue("The output should be of the type \"Average: -12.0\". Now you printed: " + inputStr, matcher.find());

        // Parse the number from the matched group
        double number = Double.parseDouble(matcher.group(1));
        return number;
    }
}
