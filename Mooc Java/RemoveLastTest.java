import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

@Points("03-17")
public class RemoveLastTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test() throws Throwable {
        ArrayList<String> strs = strings("a", "b", "c");
        check(strs);
    }

    @Test
    public void test2() throws Throwable {
        ArrayList<String> strs = strings("c", "b", "a");
        check(strs);
    }

    @Test
    public void test3() throws Throwable {
        ArrayList<String> strs = strings();
        check(strs);
    }

    // Check method for testing the RemoveLast class
    private void check(ArrayList<String> strs) throws Throwable {
        String oldOut = io.getSysOut();
        // Create a copy of the original list
        ArrayList<String> original = new ArrayList<>(strs);
        try {
            // Call the static method "removeLast" of RemoveLast class using Reflection
            Reflex.reflect(RemoveLast.class).staticMethod("removeLast").returningVoid().taking(ArrayList.class).invoke(strs);
        } catch (Throwable t) {
            fail("the removeLast method should not cause an exception. Make sure the method doesn't do anything to an empty list.\nAlso check the method with this list: " + original.toString());
        }

        // If the original list was empty, return as no further checks are needed
        if (original.size() == 0) {
            return;
        }

        // Check if the last element of the original list was removed
        assertFalse("removeLast method should remove the last element of the list.", strs.contains(original.get(original.size() - 1)));
        // Remove the last element from the original list
        original.remove(original.size() - 1);
        // Check if the remaining list matches the expected modified list
        assertEquals("The last element of the list should be removed. Don't otherwise modify the method.", strs, original);
    }

    // Helper method to create an ArrayList of strings from variable arguments
    private static ArrayList<String> strings(String... list) {
        ArrayList<String> strs = new ArrayList<>();
        for (String s : list) {
            strs.add(s);
        }
        return strs;
    }
}
