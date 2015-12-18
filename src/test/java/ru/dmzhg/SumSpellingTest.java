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
    private int twentyFourNumber;
    private int oneHundredTwentyFourNumber;
    private int oneThousandTwoHundredThirtyFiveNumber;
    private int millionNumber;
    private int hasZerosNumber;

    @Before
    public void setUp() {
        fiveNumber = 5;
        oneNumber = 1;
        tenNumber = 10;
        fourteenNumber = 14;
        thirtyFiveNumber = 35;
        twentyFourNumber = 24;
        oneHundredTwentyFourNumber = 124;
        oneThousandTwoHundredThirtyFiveNumber = 1235;
        millionNumber = 2555123;
        hasZerosNumber = 54043;
    }

    @After
    public void tearDown() {
        sum = null;
    }

    @Test
    public void shouldTranslateNumberFiveToWord() {
        assertEquals("five ", NumberToWordInterpreter.translate(fiveNumber));
    }

    @Test
    public void shouldTranslateNumberOneToWord() {
        assertEquals("one ", NumberToWordInterpreter.translate(oneNumber));
    }

    @Test
    public void shouldTranslateNumberTenToWord() {
        assertEquals("ten ", NumberToWordInterpreter.translate(tenNumber));
    }

    @Test
    public void shouldTranslateNumberFourteenToWord() {
        assertEquals("fourteen ", NumberToWordInterpreter.translate(fourteenNumber));
    }

    @Test
    public void shouldTranslateThirtyFiveNumberToWord() {
        assertEquals("thirty five ", NumberToWordInterpreter.translate(thirtyFiveNumber));
    }

    @Test
    public void shouldTranslateGivenLengthTwoNumberToWord() {

        assertEquals("twenty four ", NumberToWordInterpreter.translate(twentyFourNumber));
    }

    @Test
    public void shouldTranslateAnyLengthThreeNumberToWord() {
        assertEquals("one hundred twenty four ", NumberToWordInterpreter.translate(oneHundredTwentyFourNumber));
    }

    @Test
    public void shouldTranslateThousandNumber() {
        assertEquals("one thousand two hundred thirty five ",  NumberToWordInterpreter.translate(oneThousandTwoHundredThirtyFiveNumber));
    }

    @Test
    public void shouldTranslateMillionNumberToWord() {
        assertEquals("two million five hundred fifty five thousand one hundred twenty three ", NumberToWordInterpreter.translate(millionNumber));
    }

    @Test
    public void shouldTranslateNumberWithZerosToWord() {
        assertEquals("fifty four thousand forty three ", NumberToWordInterpreter.translate(hasZerosNumber));
    }

    @Test
    public void shouldTranslateLidiaNumberToWord() {
        assertEquals("three hundred thirty six ", NumberToWordInterpreter.translate(336));
    }
}
