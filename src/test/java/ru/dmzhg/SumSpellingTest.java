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
    private Double fiveNumber;
    private Double oneNumber;
    private Double tenNumber;
    private Double fourteenNumber;
    private Double thirtyFiveNumber;
    private Double twentyFourNumber;
    private Double oneHundredTwentyFourNumber;
    private Double oneThousandTwoHundredThirtyFiveNumber;
    private Double millionNumber;
    private Double hasZerosNumber;
    private Double oneHundredFiftyOneAndFortyFiveNumber;

    @Before
    public void setUp() {
        fiveNumber = 5D;
        oneNumber = 1D;
        tenNumber = 10D;
        fourteenNumber = 14D;
        thirtyFiveNumber = 35D;
        twentyFourNumber = 24D;
        oneHundredTwentyFourNumber = 124D;
        oneThousandTwoHundredThirtyFiveNumber = 1235D;
        millionNumber = 2555123D;
        hasZerosNumber = 54043D;
        oneHundredFiftyOneAndFortyFiveNumber = 151.45;
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
        assertEquals("three hundred thirty six ", NumberToWordInterpreter.translate(336D));
    }

    @Test
    public void shouldTranslateThirtyFiveNumberToCurrency() {
        assertEquals("thirty five ", NumberToWordInterpreter.translate(thirtyFiveNumber));
    }

    @Test
    public void shouldReactOnZeroNumber() {
        assertEquals("zero ", NumberToWordInterpreter.translate(0D));
    }

    @Test
    public void shouldTranslateLongNumberWithZerosToWord() {
        assertEquals("one hundred one thousand and zero", NumberToWordInterpreter.translate(101000D));
    }

    @Test
    public void shouldTranslateCurrencyWithCents() {
        assertEquals("one hundred fifty one and forty five ", NumberToWordInterpreter.translate(oneHundredFiftyOneAndFortyFiveNumber));
    }
}
