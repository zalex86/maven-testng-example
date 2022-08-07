import org.testng.annotations.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;

public class SumNumberTest {
    public void currentTime () {
        DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dft.format(now));
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
        currentTime();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
        currentTime();
    }

    @DataProvider(name = "sumTest", parallel = true)
    Object[][] sumDataProvider() {
        return new Object[][] {
                {10, 30, 40},
                {0, 0, 0},
                {-10, 10, 0}
        };
    }

    @Test(dataProvider = "sumTest")
    void testSum (int arg1, int arg2, int expect) {
        int sum = SimpleSumNumbs.sumNumbs(arg1, arg2);
        System.out.println(sum);
        assertEquals(sum, expect);
    }
}

