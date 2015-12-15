package main.java.ru.dmzhg;

import java.math.BigDecimal;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class NumberToWordInterpreter {
    public static String Spell(BigDecimal numberToBeSpelled) {
        String spelledNumber = "";
        String numberGroups[] = new String[10];
        int groupCount = 0;
        BigDecimal bd = new BigDecimal(555.833);
        int bdi = bd.intValue();
        String stringoBeSpelled = numberToBeSpelled.toString();
        //
        String cleanNumberString = stringoBeSpelled.replace(",", ".").replace(" ", "");
        // Detecting amount of number triads in number
        if (cleanNumberString.length() % 3 == 0) {
            groupCount = cleanNumberString.length() / 3;
        } else {○
            groupCount = 1 + cleanNumberString.length() / 3;
        }
        if (cleanNumberString.length() <= 3) {
            return spellGroup();
        }
        for (int i = 0; i <= cleanNumberString.length() / 3; i++) {
            if (cleanNumberString.length() <= 3) {
                numberGroups[i + 1] = cleanNumberString;
            }
            numberGroups[i] = stringoBeSpelled.substring(cleanNumberString.length() - 3, cleanNumberString.length());
            cleanNumberString = cleanNumberString.substring(cleanNumberString.length() * i);

        }
        for (int i = 0; cleanNumberString.length() < 3; i++) {
            System.out.println(numberGroups[i]);
        }

        return spelledNumber;

    }

    private static String spellGroup() {
        return "";
    }

    private static void hapinness() {
        System.out.println("I'm so happy to make my very virst commit to Git!9");
    }
}

