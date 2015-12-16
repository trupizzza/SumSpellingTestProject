package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class NumberToWordInterpreter {
    public static String translate(final int number) {
        String resultingWord = null;
        switch (number) {
            case 1:
                resultingWord = "one";
                break;
            case 5:
                resultingWord = "five";
                break;
            case 10:
                resultingWord = "ten";
                break;
            case 14:
                resultingWord = "fourteen";
                break;
            default:
                resultingWord = "Translation error!";

        }
        return resultingWord;
    }

}



