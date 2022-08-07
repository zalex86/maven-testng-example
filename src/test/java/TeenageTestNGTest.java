import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.*;

public class TeenageTestNGTest {

    @BeforeClass
    public void beforeClass() {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dft.format(now));
    }

    @AfterClass
    public void afterClass() {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dft.format(now));
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("TeenageTestNGTest test started");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("TeenageTestNGTest test done");
    }

    @DataProvider(name = "ageTest", parallel = true)
    Object[][] ageDataProvider() {
        return new Object[][] {
                {10, true},
                {20, false},
                {30, false},
                {40, false},
                {50, false}
        };
    }

    @Test(dataProvider = "ageTest")
    public void testIsTeenager(int age, boolean expectedResult) {
        boolean result = Teenage.isTeenager(age);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(result, expectedResult);
    }
}