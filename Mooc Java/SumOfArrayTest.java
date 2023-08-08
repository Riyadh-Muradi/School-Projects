import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-20")
public class SumOfArrayTest {

    @Test
    public void checkTheSum() {
        // An array of different lengths to test
        int[] arrayLengths = {0, 1, 2, 3, 4, 5, 10, 20, 100};

        // Create a Random instance for generating random numbers
        Random random = new Random();

        // Iterate through different array lengths
        for (int i = 0; i < arrayLengths.length; i++) {
            int length = arrayLengths[i];
            
            // Create an array of given length and populate it with random numbers
            int[] arr = new int[length];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(150);
            }
            
            // Test the sum of numbers in the array
            checkTheArray(arr);
        }
    }

    // Method to test the sum of numbers in an array
    private void checkTheArray(int[] arr) {
        int sum = 0;
        
        // Calculate the sum of numbers in the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Calculate the sum returned by the method under test
        int returnedSum = SumOfArray.sumOfNumbersInArray(arr);

        // Compare the calculated sum with the returned sum
        if (sum != returnedSum) {
            // If the sums don't match, fail the test and provide details
            fail("The sum returned by the method was " + returnedSum + ", when it was supposed to be: " + sum + ". The content of the array was: " + Arrays.toString(arr));
        }
    }
}
