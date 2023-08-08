import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-21")
public class ArrayPrinterTest {

    // This method tests the ArrayPrinter.printNeatly() method
    @Test
    public void checkOutput() {
        // Define different array lengths to test
        int[] arrayLengths = {1, 2, 3, 4, 5, 10, 20, 100};

        Random random = new Random();
        // Loop through each defined array length
        for (int i = 0; i < arrayLengths.length; i++) {
            int length = arrayLengths[i];
            int[] arr = new int[length];

            // Fill the array with random integers between 0 and 149
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(150);
            }

            // Test the current array using the checkArray() method
            checkArray(arr);
        }
    }

    // This method checks the output of the ArrayPrinter.printNeatly() method
    private void checkArray(int[] arr) {
        MockInOut mio = new MockInOut("");

        // Call the ArrayPrinter.printNeatly() method on the given array
        ArrayPrinter.printNeatly(arr);

        // Get the printed output
        String output = mio.getOutput().trim();
        if (arr.length == 0) {
            // If the array is empty, the output should also be empty
            if (!output.isEmpty()) {
                fail("When the printNeatly method was given an empty array, it printed something anyway: " + output);
            }
            return;
        }

        // Check if the output is empty
        if (output.isEmpty()) {
            fail("You didn't print anything when the array was " + Arrays.toString(arr));
        }

        // Split the output by commas to separate the numbers
        String[] numbers = output.split(",", -1);
        if (numbers.length == 0) {
            fail("You didn't print anything when the array was " + Arrays.toString(arr));
        }
        if (numbers.length != arr.length) {
            // Check if the number of commas in the output matches the number of array elements
            fail("The output should contain precisely " + (arr.length - 1)
                    + " commas, while there were  " + (numbers.length - 1) + ". Content of the array was: " + Arrays.toString(arr));
        }

        // Check if the output has a line break at the end
        int end = Math.max(0, output.length() - 2);
        assertFalse("Your output doesn't have a line break in the end! When the input was " + Arrays.toString(arr) + " you printed \n" + output,
                output.substring(0, end).contains("\n"));

        // Iterate through each number in the output
        for (int i = 0; i < numbers.length; i++) {
            String numberString = numbers[i].trim();
            if (numberString.isEmpty()) {
                fail("The output should have a number after each comma. Make sure the output doesn't end with a comma. You printed: " + output);
            }

            int number;
            try {
                // Convert the number string to an integer
                number = Integer.valueOf(numberString);
            } catch (Exception e) {
                // If the conversion fails, the output is not formatted correctly
                fail("The output should only contain numbers separated by commas! This is not a number: " + numberString + ". You printed: " + output);
                return;
            }

            // Compare the number in the output with the original array
            if (number != arr[i]) {
                fail("At the index " + i + " of the array there was " + arr[i] + ", but the output had: " + number);
            }
        }
    }
}
