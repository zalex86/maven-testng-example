import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TeenageTestNGTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }

    @DataProvider(name = "ageTest")
    Object[][] ageDataProvider() {
        return new Object[][] {
                {10, true},
                {20, false}
        };
    }

    @Test(dataProvider = "ageTest")
    public void testIsTeenager(int age, boolean result) {
        assertEquals(result, Teenage.isTeenager(age));
    }
}