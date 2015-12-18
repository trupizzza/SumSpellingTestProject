package test.java.ru.dmzhg;

import main.java.ru.dmzhg.CurrencyToWordInterpreter;
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
    public void translateNumberToRussianCurrencyWord() {
        assertEquals("сорок одна тысяча рублей ноль копеек ", CurrencyToWordInterpreter.convert(41000D));
    }
    @Test
    public void translateAnotherNumberToRussianCurrencyWord() {
        assertEquals("триста пятьдесят шесть рублей семьдесят восемь копеек ", CurrencyToWordInterpreter.convert(356.78D));
    }

    @Test
    public void translateComplexRusNumberToCurrencyWord() {
        assertEquals("два миллиона четыреста пятьдесят одна тысяча пятьсот рублей тридцать одна копейка ", CurrencyToWordInterpreter.convert(2451500.31D));
    }

    @Test
    public void translateZeroRubZeroKopToCurrencyWord() {
        assertEquals("ноль рублей ноль копеек", CurrencyToWordInterpreter.convert(0.0D));
    }
}
