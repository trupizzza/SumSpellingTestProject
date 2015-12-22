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
    private Double millionNumber;
    private Double hasZerosNumber;
    private Double oneHundredFiftyOneAndFortyFiveNumber;
    private double fortyOneThousandNumber;
    private double zeroRubZeroKopecks;
    private double fiftyOneRubFirtyOneKop;
    private double twoMillionFoouHundredFiftyOneThousandFiftyRub31Kop;
    private double threeHundredFiftySixRub78Kop;
    private double twoHundredTwoThousand711Rub82Kop;
    private double oneMillion12Thousand3Rub43Kop;

    @Before
    public void setUp() {
        millionNumber = 2555123.00;
        hasZerosNumber = 54043.00;
        threeHundredFiftySixRub78Kop = 356.78;
        oneHundredFiftyOneAndFortyFiveNumber = 151.45;
        fortyOneThousandNumber = 41000.00;
        zeroRubZeroKopecks = 0.00;
        fiftyOneRubFirtyOneKop = 51.41;
        twoMillionFoouHundredFiftyOneThousandFiftyRub31Kop = 2451500.31;
        twoHundredTwoThousand711Rub82Kop = 202711.82;
        oneMillion12Thousand3Rub43Kop = 1012003.43;
    }

    @After
    public void tearDown() {
    }

    @Test
    public void translateFortyOneThousandToRusCurrencyWord() {
        assertEquals("сорок одна тысяча рублей ноль копеек ", CurrencyToWordInterpreter.convert(fortyOneThousandNumber));
    }

    @Test
    public void translate356Rub78KopToRusCurrencyWord() {
        assertEquals("триста пятьдесят шесть рублей семьдесят восемь копеек ", CurrencyToWordInterpreter.convert(threeHundredFiftySixRub78Kop));
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
    public void translate202Thousands711Rub82KopToRusCurrencyWord() {
        assertEquals("двести две тысячи семьсот одиннадцать рублей восемьдесят две копейки ", CurrencyToWordInterpreter.convert(twoHundredTwoThousand711Rub82Kop));
    }

    @Test
    public void translate1Million12Thousands3Rub43KopToRusCurrencyWord() {
        assertEquals("один миллион двенадцать тысяч три рубля сорок три копейки ", CurrencyToWordInterpreter.convert(oneMillion12Thousand3Rub43Kop = 1012003.43));
    }

    @Test
    public void translateNegativeNumberToRusCurrencyWord() {
        assertEquals("минус два рубля ноль копеек", CurrencyToWordInterpreter.convert(-2.0));
    }

    @Test
    public void smallTestForStringReverse() {
        assertEquals("95.4321", CurrencyToWordInterpreter.retrieveSymbolAsWord(1234.59));
    }
}
