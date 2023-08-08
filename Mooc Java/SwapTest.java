import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("03-18")
public class SwapTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void example1() throws Throwable {
        // Set the standard input for the test case
        io.setSysIn("2\n4\n");
        // Call the main method of the Swap class
        Swap.main(new String[]{});
        // Read the printed numbers from the output
        List<Integer> numbers = readNumbers();
        
        // Check if the output contains the correct number of elements
        assertTrue("You modified the printing of the numbers, didn't you? The output was expected to contain 10 numbers, now there were " + numbers.size() + " numbers.", numbers.size() == 10);
        
        // Extract the last 5 numbers from the list
        numbers = numbers.subList(5, numbers.size());
        
        // Define the expected order after swapping
        int[] expected = {1, 3, 9, 7, 5};

        // Compare the expected and actual values after swapping
        for (int i = 0; i < expected.length; i++) {
            assertTrue("When the values in indices 2 and 4 were swapped, index " + i + " should have contained " + expected[i] + ". Now it contained " + numbers.get(i), expected[i] == numbers.get(i));
        }
    }

    // Similar test cases follow for example2() and example3()

    // Helper method to read printed numbers from the output
    private List<Integer> readNumbers() {
        return Arrays.stream(io.getSysOut().split("\n"))
                .filter(l -> !l.trim().isEmpty())
                .filter(l -> {
                    try {
                        Integer.valueOf(l.trim());
                        return true;
                    } catch (NumberFormatException t) {
                    }
                    return false;
                }).map(i -> Integer.valueOf(i)).collect(Collectors.toList());
    }
}
