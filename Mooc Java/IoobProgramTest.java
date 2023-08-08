import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("03-03")
public class IoobProgramTest {

    // Test method to check if the program causes an IndexOutOfBoundsException
    @Test
    public void causingIndexOutOfBoundsException() {
        try {
            // Call the main method of IoobProgram class
            IoobProgram.main(new String[]{});
            
            // If the program execution does not throw an exception, fail the test
            fail("Execution of the program should cause an IndexOutOfBoundsException. Now it didn't happen.");
        } catch (IndexOutOfBoundsException e) {
            // If an IndexOutOfBoundsException is caught, the test is successful
            // No action needed as the exception is expected
        }
    }
}
