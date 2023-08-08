import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-10")
public class IndexOfTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method
    @Test
    public void test() {
        int[][] inputs = {
            {51, 22, -11, -140, -18},
            {1, 7},
            {3, 2},
            {-3, -2, -141, 22, 22, 7}
        };

        // Loop through each array of input numbers
        for (int i = 0; i < inputs.length; i++) {
            // Check for two different numbers in the same input array
            check(7, inputs[i]);
            check(22, inputs[i]);
        }
    }

    // Helper method to check the indices of a given number in an array
    private void check(int searching, int... numbers) {
        int oldOut = io.getSysOut().length();

        // Set to store indices where the searching number is found
        Set<Integer> indices = new HashSet<>();

        String in = "";
        for (int i = 0; i < numbers.length; i++) {
            in += numbers[i] + "\n";

            // Add index to the set if the number matches the searching number
            if (searching == numbers[i]) {
                indices.add(i);
            }
        }

        // Append sentinel values to end the input
        in += "-1\n";
        in += "" + searching + "\n";

        // Set the prepared input
        io.setSysIn(in);

        // Call the main method of IndexOf class
        callMain(IndexOf.class);

        // Get the printed output after input
        String out = io.getSysOut().substring(oldOut);

        assertTrue("you're not printing anything!", out.length() > 0);

        assertFalse("The word \"no\" should not appear in the output. Now the output was:\n" + out, out.contains("no"));

        // Validate that the indices are printed for the searching number
        for (int index : indices) {
            assertTrue("When the number is found, the output should tell all the indices at which the number was found.\nWhen the input was:\n" + in + "\nOutput was:\n" + out, out.contains(" " + index));
        }
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
    private static int getLastNumber(String inputStr) {
        String patternStr = "(?s).*?(\\d+)\\s*$";
        Matcher matcher = Pattern.compile(patternStr).matcher(inputStr);

        assertTrue("Output should be of the type \"Num is at index 10\". Now you printed: " + inputStr, matcher.find());

        int number = Integer.valueOf(matcher.group(1));
        return number;
    }
}
