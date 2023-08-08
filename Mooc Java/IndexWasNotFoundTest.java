import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.Test;

@Points("03-19")
public class IndexWasNotFoundTest {

    // Create a MockStdio rule to capture input and output
    @Rule
    public MockStdio io = new MockStdio();

    // Test method to check example input 3
    @Test
    public void example1() throws Throwable {
        // Set the system input to "3"
        io.setSysIn("3\n");

        // Call the main method of IndexWasNotFound class
        IndexWasNotFound.main(new String[]{});

        // Validate that the output contains the expected message
        assertTrue("When the use input was 3, output was expected to be \"3 is at index 4.\".\nNow the output was:\n" + io.getSysOut(), io.getSysOut().contains("3 is at i") && io.getSysOut().contains(" 4."));
    }

    // Test method to check example input 7
    @Test
    public void example2() throws Throwable {
        // Set the system input to "7"
        io.setSysIn("7\n");

        // Call the main method of IndexWasNotFound class
        IndexWasNotFound.main(new String[]{});

        // Validate that the output contains the expected message
        assertTrue("When the user input was 7, output was expected to be \"7 is at index 7.\".\nNow the output was:\n" + io.getSysOut(), io.getSysOut().contains("7 is at i") && io.getSysOut().contains(" 7."));
    }

    // Test method to check example input 22
    @Test
    public void example3() throws Throwable {
        // Set the system input to "22"
        io.setSysIn("22\n");

        // Call the main method of IndexWasNotFound class
        IndexWasNotFound.main(new String[]{});

        // Validate that the output contains the expected message
        assertTrue("When the user input was 22, output was expected to be \"22 was not found.\".\nNow the output was:\n" + io.getSysOut(), io.getSysOut().contains("22 was not f"));
    }

    // Additional test method to check input 0
    @Test
    public void extra1() throws Throwable {
        // Set the system input to "0"
        io.setSysIn("0\n");

        // Call the main method of IndexWasNotFound class
        IndexWasNotFound.main(new String[]{});

        // Validate that the output contains the expected message
        assertTrue("When the user input was 0, output was expected to be \"0 is at index 5.\".\nNow the output was:\n" + io.getSysOut(), io.getSysOut().contains("0 is at in") && io.getSysOut().contains(" 5."));
    }

    // Additional test method to check input 5
    @Test
    public void extra2() throws Throwable {
        // Set the system input to "5"
        io.setSysIn("5\n");

        // Call the main method of IndexWasNotFound class
        IndexWasNotFound.main(new String[]{});

        // Validate that the output contains the expected message
        assertTrue("When the user input was 5, the output was supposed to be \"5 was not found.\".\nNow the output was:\n" + io.getSysOut(), io.getSysOut().contains("5 was not f"));
    }
}
