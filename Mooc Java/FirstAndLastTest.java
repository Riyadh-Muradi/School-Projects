import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-06")
public class FirstAndLastTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method
    @Test
    public void test() {
        // Arrays of strings to be tested
        String[][] inputs = {
            {"Thomas", "Elizabeth", "Axel", "Mary", "", "Thomas", "Mary"},
            {"Elizabeth", "Axel", "Mary", "", "Elizabeth", "Mary"},
            {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "", "First", "Seventh"}
        };

        // Loop through each array of strings
        for (int i = 0; i < inputs.length; i++) {
            check(inputs[i]);
        }
    }

    // Helper method to check first and last names and output
    private void check(String... strings) {
        int oldOut = io.getSysOut().length();

        // Prepare input string by joining the input strings (excluding last two)
        String in = "";
        for (int i = 0; i < strings.length - 2; i++) {
            in += strings[i] + "\n";
        }

        // Set the prepared input
        io.setSysIn(in);

        // Call the main method of FirstAndLast class
        callMain(FirstAndLast.class);

        // Get the printed output after input
        String out = io.getSysOut().substring(oldOut);

        assertTrue("you're not printing anything!", out.length() > 0);

        // Get the last two words from the output
        String[] result = getLastWords(out);

        // Get the expected last two words
        String expected1 = strings[strings.length - 2];
        String expected2 = strings[strings.length - 1];

        // Iterate through each input name and validate against output
        for (int i = 0; i < strings.length - 1; i++) {
            String name = strings[i];
            if (name.equals(expected1) || name.equals(expected2)) {
                continue;
            }

            if (name.equals("")) {
                continue;
            }

            if (out.contains(name)) {
                fail("Input:\n" + in + "\nThe output was not expected to be \"" + name + "\".\noutput was:\n" + out);
            }
        }

        // Prepare an error message for assertion
        String errorMsg = "Input:\n" + in + "\n\n Expected:\n" + expected1 + "\n" + expected2 + "\nyou printed: \"" + result + "\"\n";

        // Compare the expected and actual last two words
        assertEquals(errorMsg, expected1, result[0]);
        assertEquals(errorMsg, expected2, result[1]);
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

    // Helper method to extract the last two words from a string
    private static String[] getLastWords(String inputStr) {
        String[] parts = inputStr.split("\\s+");
        return new String[]{parts[parts.length - 2], parts[parts.length - 1]};
    }
}
