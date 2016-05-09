/**
 * Created by Firdaus on 2/20/2016.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnit1b {
    private main temp;
    @Test public void testFindLast1B()      //Problem 1 part B
        {
            int a[] = {2,3,5};
            temp = new main();
            assertEquals((int) 1, temp.findLast(a, 3));
        }
    @Test public void testFindLast1C()      //Problem 1 part C
        {
            int a[] = {2,3,5};
            int b[] = {};
            temp = new main();
            assertEquals((int) -1, temp.findLast(a, 2));
        }
    @Test public void testFindLast1D()      //Problem 1 part D
        {
            int a[] = {2,3,5};
            temp = new main();
            assertEquals((int) 0, temp.findLast(a, 2));
        }
}
