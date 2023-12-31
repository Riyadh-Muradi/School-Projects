import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-02")
public class SecondPlusThirdTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        String[][] input = {{"1", "3", "5", "7", "0", "8"}, {"2", "3", "4", "0", "7"}};

        for (int i = 0; i < input.length; i++) {
            check(input[i]);
        }
    }

    // Method to perform the test on input strings
    private void check(String... strs) {
        int oldOut = io.getSysOut().length();

        // Construct the input string
        String in = "";
        for (int i = 0; i < strs.length - 1; i++) {
            in += strs[i] + "\n";
        }

        // Set the input for the program and call its main method
        io.setSysIn(in);
        callMain(SecondPlusThird.class);
        String out = io.getSysOut().substring(oldOut);

        // Ensure that the program is printing something
        assertTrue("you're not printing anything!", out.length() > 0);

        // Extract the last printed output from the program
        String result = getLast(out);
        String expectedResult = strs[strs.length - 1];

        // Check if each number from input is expected to be in output
        for (int i = 0; i < strs.length - 1; i++) {
            String num = strs[i];
            if (num.equals(expectedResult)) {
                continue;
            }

            if (num.equals("")) {
                continue;
            }

            // Fail if a number that wasn't supposed to be in output is found
            if (out.contains(num)) {
                fail("Input:\n" + in + "\nThe output was not expected to contain \"" + num + "\".\nThe output was:\n" + out);
            }
        }

        // Construct an error message if the result doesn't match the expected
        String errorMsg = "Input:\n" + in + "\n\n Expected output: \"" + expectedResult + "\", the output was: \"" + result + "\"\n";
        // Check if the result matches the expected result
        assertEquals(errorMsg, expectedResult, result);
    }

    // Method to invoke the main method of a class using Reflection
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

    // Method to extract the last piece of text from a given string
    private static String getLast(String inputStr) {
        String[] pieces = inputStr.split("\\s+");
        return pieces[pieces.length - 1];
    }
}
