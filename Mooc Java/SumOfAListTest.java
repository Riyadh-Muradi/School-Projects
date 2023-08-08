import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-12")
public class SumOfAListTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        int[][] inputs = {
            {3, 6, 9, 12, 15, -1},
            {1, -1},
            {9, -1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1}
        };

        // Iterate through different sets of input numbers
        for (int[] input : inputs) {
            check(input);
        }
    }

    // Method to perform the test on input numbers
    private void check(int[] inputNumbers) {
        int oldOut = io.getSysOut().length();
        String input = "";
        int sum = 0;
        
        // Construct the input and calculate the sum
        for (int num : inputNumbers) {
            if (num != -1) {
                sum += num;
            }

            input += num + "\n";
        }

        // Set the input for the program and call its main method
        io.setSysIn(input);
        callMain(SumOfAList.class);
        String out = io.getSysOut().substring(oldOut);

        // Extract the last printed number (sum) from the program's output
        int result = getLastNumber(out);

        // Prepare input string for error message
        String errorMsgInput = input.replaceAll("\n", " ").trim();
        errorMsgInput = errorMsgInput.replaceAll(" ", " + ").trim();
        String errorMsg = "the sum " + errorMsgInput + " should be " + sum + " you printed \"" + result + "\"";

        // Ensure that the program is printing something
        assertTrue("you're not printing anything!", out.length() > 0);
        // Check if the calculated sum matches the printed result
        assertEquals(errorMsg, sum, result);
    }

    // Method to invoke the main method of a class using Reflection
    private void callMain(Class kl) {
        try {
            kl = ReflectionUtils.newInstanceOfClass(kl);
            String x[] = new String[0];
            Method m = ReflectionUtils.requireMethod(kl, "main", x.getClass());
            ReflectionUtils.invokeMethod(Void.TYPE, m, null, (Object) x);
        } catch (NoSuchElementException e) {
            fail("Make sure the prompting stops when the user gives a zero.");
        } catch (Throwable e) {
            fail(kl + " class public static void main(String[] args) -method has disappeared!");
        }
    }

    // Method to extract the last number from a given string
    private static int getLastNumber(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("The last line of the output should be of the type \"Sum: 10\"", matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;
    }
}
