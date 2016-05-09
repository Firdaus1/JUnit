/**
 * Created by Firdaus on 2/20/2016.
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import junit.framework.JUnit4TestAdapter;

@RunWith(Suite.class)
@Suite.SuiteClasses({JUnit1b.class}) //Adding the test class here

public class allTests {
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(suite());
    }

    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(allTests.class);
    }
}
