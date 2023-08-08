import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-01")
public class ThirdElementTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        // Input data: Each row has a list of names and the expected third element
        String[][] input = {{"Tom", "Emma", "Alex", "Mary", "", "Alex"}, {"Emma", "Alex", "Mary", "", "Mary"}};

        // Loop through each input row and perform the test
        for (int i = 0; i < input.length; i++) {
            check(input[i]);
        }
    }

    // Method to perform the individual test with input and expected output
    private void check(String... strings) {
        int oldOut = io.getSysOut().length();

        // Construct the input string for the test case
        String in = "";
        for (int i = 0; i < strings.length - 1; i++) {
            in += strings[i] + "\n";
        }

        // Set the constructed input as the system input
        io.setSysIn(in);
        // Call the main method of ThirdElement class
        callMain(ThirdElement.class);
        // Get the output after the call to main
        String out = io.getSysOut().substring(oldOut);

        // Ensure that something is printed
        assertTrue("you're not printing anything!", out.length() > 0);

        // Get the actual answer from the output
        String ans = getLastWord(out);
        // Get the expected answer from the input
        String expectedAns = strings[strings.length - 1];

        // Compare each name in input with the expected output
        for (int i = 0; i < strings.length - 1; i++) {
            String name = strings[i];
            if (name.equals(expectedAns)) {
                continue;
            }

            // If name is empty, skip
            if (name.equals("")) {
                continue;
            }

            // If unexpected name is found in the output, fail the test
            if (out.contains(name)) {
                fail("Input:\n" + in + "\n the following output was not expected \"" + name + "\", but it got printed.\nThe output was:\n" + out);
            }
        }

        // Create an error message for assertion
        String errorMsg = "Input:\n" + in + "\n\n Expected output: \"" + expectedAns + "\", you printed: \"" + ans + "\"\n";
        // Assert that the actual answer matches the expected answer
        assertEquals(errorMsg, expectedAns, ans);
    }

    // Method to call the main method of a class using reflection
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

    // Method to get the last word from an input string
    private static String getLastWord(String inputStr) {
        String[] parts = inputStr.split("\\s+");
        return parts[parts.length - 1];
    }
}
