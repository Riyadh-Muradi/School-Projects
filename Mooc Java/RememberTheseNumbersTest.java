import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-07")
public class RememberTheseNumbersTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() {
        String[][] inputs = {{"3", "2", "1", "4", "7", "-1"}, {"3", "9", "2", "8", "-1"}};

        // Iterate over the input arrays and call the check method for each input
        for (int i = 0; i < inputs.length; i++) {
            check(inputs[i]);
        }
    }

    private void check(String... input) {
        int oldOut = io.getSysOut().length();

        // Create an empty string to store input values and an ArrayList to store integer values
        String in = "";
        List<Integer> numbers = new ArrayList<>();
        
        // Loop through the input values
        for (int i = 0; i < input.length; i++) {
            in += input[i] + "\n";
            // Parse each input value as an integer and add it to the numbers ArrayList
            numbers.add(Integer.valueOf(input[i]));
        }

        // Set the simulated system input
        io.setSysIn(in);
        // Call the main method of RememberTheseNumbers class
        callMain(RememberTheseNumbers.class);
        // Get the program's output, excluding the original system output
        String out = io.getSysOut().substring(oldOut);

        // Check if the program is printing anything
        assertTrue("you're not printing anything!", out.length() > 0);

        // Iterate over numbers from 0 to 49 and check if they are printed or not as expected
        for (int i = 0; i < 50; i++) {
            if (numbers.contains(i) && !out.contains("" + i)) {
                fail("Input:\n" + in + "\nThis number was not expected: \"" + i + "\", but it got printed.\nOutput was:\n" + out);
            }

            if (!numbers.contains(i) && out.contains("" + i)) {
                fail("Input:\n" + in + "\nThis number was not expected: \"" + i + "\", but it got printed.\nOutput was:\n" + out);
            }
        }
    }

    // Helper method to call the main method of a given class using ReflectionUtils
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

    // Helper method to split input string and get the last two words
    private static String[] getLastWords(String inputStr) {
        String[] parts = inputStr.split("\\s+");
        return new String[]{parts[parts.length - 2], parts[parts.length - 1]};
    }
}
