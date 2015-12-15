package test.java.ru.dmzhg;

import main.java.ru.dmzhg.NumberToWordInterpreter;
import main.java.ru.dmzhg.SummaSpellingOut;
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

    @Before
    public void setUp() {


        numberToBeSpelled = new Integer(1150453);
        sum = new Integer(500);
    }

    @After
    public void tearDown() {
        sum = null;
    }

    @Test
    public void shouldTranslateIntegerToWord() {

        String numbers = SummaSpellingOut.getAmountWithWord(sum.toString());
        int indexQty = numbers.indexOf("руб");
        numbers = numbers.substring(0, indexQty - 1);
        assertEquals("Пятьсот", numbers);

    }

    @Test
    public void shouldTranslateMillionToWord() {
        assertEquals("Один миллион сто пятьдесят тысяч четыреста пятьдесят три руб. 00 коп.", NumberToWordInterpreter.Spell(numberToBeSpelled));


//    }
    }
}
