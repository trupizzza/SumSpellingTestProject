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
    private double fortyOneThousandNumber;
    private double zeroRubZeroKopecks;
    private double fiftyOneRubFirtyOneKop;
    private double twoMillionFoouHundredFiftyOneThousandFiftyRub31Kop;

    @Before
    public void setUp() {
        millionNumber = 2555123D;
        hasZerosNumber = 54043D;
        oneHundredFiftyOneAndFortyFiveNumber = 151.45;
        fortyOneThousandNumber = 41000D;
        zeroRubZeroKopecks = 0.0D;
        fiftyOneRubFirtyOneKop = 51.41D;
        twoMillionFoouHundredFiftyOneThousandFiftyRub31Kop = 2451500.31D;
    }

    @After
    public void tearDown() {
        sum = null;
    }

    @Test
    public void translateFortyOneThousandToRusCurrencyWord() {
        assertEquals("сорок одна тысяча рублей ноль копеек ", CurrencyToWordInterpreter.convert(fortyOneThousandNumber));
    }
    @Test
    public void translateAnotherNumberToRusCurrencyWord() {
        assertEquals("триста пятьдесят шесть рублей семьдесят восемь копеек ", CurrencyToWordInterpreter.convert(356.78D));
    }

    @Test
    public void translate2451500Point31NumberToRusCurrencyWord() {
        assertEquals("два миллиона четыреста пятьдесят одна тысяча пятьсот рублей тридцать одна копейка ", CurrencyToWordInterpreter.convert(twoMillionFoouHundredFiftyOneThousandFiftyRub31Kop));
    }

    @Test
    public void translateZeroRubZeroKopToRusCurrencyWord() {
        assertEquals("ноль рублей ноль копеек ", CurrencyToWordInterpreter.convert(zeroRubZeroKopecks));
    }
    @Test
    public void translate51Rub41KopToRusCurrencyWord() {
        assertEquals("пятьдесят один рубль сорок одна копейка ", CurrencyToWordInterpreter.convert(fiftyOneRubFirtyOneKop));
    }
    @Test
    public void translate202Thousands711Rub82KopToRusCurrencyWord()
    {
        assertEquals("двести две тысячи семьсот одиннадцать рублей восемьдесят две копейки ", CurrencyToWordInterpreter.convert(202711.82D));
    }

    @Test
    public void translateSumToWord() {
        assertEquals("один миллион двенадцать тысяч три рубля сорок три копейки ", CurrencyToWordInterpreter.convert(1012003.43D));
    }
}
