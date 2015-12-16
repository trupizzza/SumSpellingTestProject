package test.java.ru.dmzhg;

import main.java.ru.dmzhg.NumberToWordInterpreter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DMZHG on 10.12.2015.
 */


public class SumSpellingTest {
    private Integer sum;
    private Integer numberToBeSpelled;
    private Integer engNum;
    private Integer fiveNumber;
    private int oneNumber;
    private int tenNumber;
    private int fourteenNumber;
    private int thirtyFiveNumber;

    @Before
    public void setUp() {

        fiveNumber = 5;
        oneNumber = 1;
        tenNumber = 10;
        fourteenNumber = 14;
        thirtyFiveNumber = 35;

    }

    @After
    public void tearDown() {
        sum = null;
    }

    @Test
    public void shouldTranslateNumberFiveToWord() {
        assertEquals("five", NumberToWordInterpreter.translate(fiveNumber));
    }

    @Test
    public void shouldTranslateNumberOneToWord() {
        assertEquals("one", NumberToWordInterpreter.translate(oneNumber));
    }

    @Test
    public void shouldTranslateNumberTenToWord() {
        assertEquals("ten", NumberToWordInterpreter.translate(tenNumber));
    }

    @Test
    public void shouldTranslateNumberFourteenToWord() {
        assertEquals("fourteen", NumberToWordInterpreter.translate(fourteenNumber));
    }

    @Test
    public void shouldTranslateThirtyFiveNumberToWord() {
        assertEquals("thirty five", NumberToWordInterpreter.translate(thirtyFiveNumber));
    }
}
