import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-09")
public class GreatestInListTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method
    @Test
    public void test() {
        // Arrays of input numbers
        int[][] inputs = {
            {3, 6, 9, 12, 15, -1},
            {1, -1},
            {9, -1},
            {-40200, 123, 999, 999999, 9, -1},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1}
        };

        // Loop through each array of input numbers
        for (int[] input : inputs) {
            check(input);
        }
    }

    // Helper method to check the greatest number in the list
    private void check(int[] inputNumbers) {
        int oldOut = io.getSysOut().length();
        String input = "";
        int biggest = inputNumbers[0];

        // Prepare input string and find the greatest number
        for (int num : inputNumbers) {
            if (num != -1 && num > biggest) {
                biggest = num;
            }
            input += num + "\n";
        }

        // Set the prepared input
        io.setSysIn(input);

        // Call the main method of GreatestInList class
        callMain(GreatestInList.class);

        // Get the printed output after input
        String out = io.getSysOut().substring(oldOut);

        // Get the greatest number from the output
        int result = getLastNumber(out);

        // Prepare the input string for comparison
        input = input.replaceAll("\n", " ").trim();

        // Prepare an error message for assertion
        String errorMsg = "When the input was:\n" + input + "\nThe greatest number should be " + biggest + " you printed \"" + result + "\"";

        assertTrue("you're not printing anything!", out.length() > 0);
        assertEquals(errorMsg, biggest, result);
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

    // Helper method to extract the last number from a string
    private static int getLastNumber(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";

        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("The last printed line should be of the type \"The greatest number: 10\"", matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;
    }
}
