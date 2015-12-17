package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class NumberToWordInterpreter {
    public static String translate(final int number) {
        int length = 0;
        int numberLength = 0;
        int groupCount = 0;
        String[] separatedNumberGroupsStrings;
        numberLength = Integer.toString(number).length();


        if (numberLength % 3 == 0) {
            groupCount = numberLength / 3;
        } else {
            groupCount = (numberLength / 3) + 1;
        }
        separatedNumberGroupsStrings = new String[groupCount];
        String numberString = Integer.toString(number);
        for (int i = 0; i < groupCount; i++) {
            if (numberString.length() <= 3) {
                separatedNumberGroupsStrings[i] = numberString;
            } else {
                separatedNumberGroupsStrings[i] = numberString.substring(numberString.length() - 3, numberString.length());
            }
            switch (separatedNumberGroupsStrings[separatedNumberGroupsStrings.length].length()) {
                case 1:
                    return checkFirstNumber(separatedNumberGroupsStrings[length]);
                case 2:
                    return checkSecondNumber(separatedNumberGroupsStrings[length]) + checkFirstNumber(separatedNumberGroupsStrings[length].substring(1));
                case 3:
                default:
                    return "";
            }

        }
        return "Translation problem!";
    }

    private static String checkSecondNumber(String numberString) {
        String resultingWord = "";
        int integerNumber = Integer.valueOf(numberString);
        if (integerNumber > 20) {
            switch (integerNumber) {
                case
            }
            switch (integerNumber) {
                case 10:
                    resultingWord = "ten";
                    break;
                case 11:
                    resultingWord = "eleven";
                    break;
                case 12:
                    resultingWord = "twelve";
                    break;
                case 13:
                    resultingWord = "thirteen";
                    break;
                case 14:
                    resultingWord = "fourteen";
                    break;
                case 15:
                    resultingWord = "fifteen";
                    break;
                case 16:
                    resultingWord = "sixteen";
                    break;
                case 17:
                    resultingWord = "seventeen";
                    break;
                case 18:
                    resultingWord = "eighteen";
                    break;
                case 19:
                    resultingWord = "nineteen";
                    break;
                case 20:
                    resultingWord = "twenty";
                    break;
                default:
                    resultingWord = "Translation error!";
                    break;
            }
            return resultingWord;
        }

    public static String checkFirstNumber(String numberString) {
        String resultingWord;
        switch (numberString.charAt(0)) {
            case '1':
                resultingWord = "one";
                break;
            case '2':
                resultingWord = "two";
                break;
            case '3':
                resultingWord = "three";
                break;
            case '4':
                resultingWord = "four";
                break;
            case '5':
                resultingWord = "five";
                break;
            case '6':
                resultingWord = "six";
                break;
            case '7':
                resultingWord = "seven";
                break;
            case '8':
                resultingWord = "eight";
                break;
            case '9':
                resultingWord = "nine";
                break;
            default:
                return "Translation error!";
        }
        return resultingWord;
    }
}


//

//
//return resultingWord;
//        }
//
//        }



