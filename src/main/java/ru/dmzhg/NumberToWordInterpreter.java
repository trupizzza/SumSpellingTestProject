package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class NumberToWordInterpreter {

    private static String[] triadDefinition = new String[]{"", "thousand ", "million ", "billion "};


    public static String translate(final int number) {
        String completeNumberWordResult = "";
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
                numberString = numberString.substring(0, numberString.length() - 3);
            }
        }
        for (int i = 0; i < groupCount; i++) {
            switch (separatedNumberGroupsStrings[i].length()) {
                case 1:
                    completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i]) + triadDefinition[i] + completeNumberWordResult;
                    break;
                case 2:
                    completeNumberWordResult = checkSecondNumber(separatedNumberGroupsStrings[i]) + triadDefinition[i] + completeNumberWordResult;
                    break;
                //TODO: we really need such structure just because of hundreds or we can make it easier?
                case 3:
                    if (checkFirstNumber(separatedNumberGroupsStrings[i]).equals("")) {
                        completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i]) +
                                checkSecondNumber(separatedNumberGroupsStrings[i].substring(1)) + triadDefinition[i] + completeNumberWordResult;
                    } else {
                        completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i]) + "hundred " +
                                checkSecondNumber(separatedNumberGroupsStrings[i].substring(1)) + triadDefinition[i] + completeNumberWordResult;
                    }
                    break;
                default:
                    return "";
            }

        }
        return completeNumberWordResult;
    }

    private static String checkSecondNumber(String numberString) {
        String resultingWord = "";
        int integerNumber = Integer.valueOf(numberString);
        if (integerNumber < 20) {
            switch (integerNumber) {
                case 10:
                    resultingWord = "ten ";
                    break;
                case 11:
                    resultingWord = "eleven ";
                    break;
                case 12:
                    resultingWord = "twelve ";
                    break;
                case 13:
                    resultingWord = "thirteen ";
                    break;
                case 14:
                    resultingWord = "fourteen ";
                    break;
                case 15:
                    resultingWord = "fifteen ";
                    break;
                case 16:
                    resultingWord = "sixteen ";
                    break;
                case 17:
                    resultingWord = "seventeen ";
                    break;
                case 18:
                    resultingWord = "eighteen ";
                    break;
                case 19:
                    resultingWord = "nineteen ";
                    break;
                default:
                    resultingWord = "Translation error!";
                    break;
            }
            return resultingWord;
        } else {
            switch (numberString.charAt(0)) {
                case '2':
                    resultingWord = "twenty ";
                    break;
                case '3':
                    resultingWord = "thirty ";
                    break;
                case '4':
                    resultingWord = "forty ";
                    break;
                case '5':
                    resultingWord = "fifty ";
                    break;
                case '6':
                    resultingWord = "sixty ";
                    break;
                case '7':
                    resultingWord = "seventy ";
                    break;
                case '8':
                    resultingWord = "eighty ";
                    break;
                case '9':
                    resultingWord = "ninety ";
                    break;
                default:
                    return "Translation error!";
            }
            resultingWord += checkFirstNumber(numberString.substring(1));
        }
        return resultingWord;
    }

    private static String checkFirstNumber(String numberString) {
        String resultingWord;
        switch (numberString.charAt(0)) {
            case '1':
                resultingWord = "one ";
                break;
            case '2':
                resultingWord = "two ";
                break;
            case '3':
                resultingWord = "three ";
                break;
            case '4':
                resultingWord = "four ";
                break;
            case '5':
                resultingWord = "five ";
                break;
            case '6':
                resultingWord = "six ";
                break;
            case '7':
                resultingWord = "seven ";
                break;
            case '8':
                resultingWord = "eight ";
                break;
            case '9':
                resultingWord = "nine ";
                break;
            case '0':
                resultingWord = "";
                break;
            default:
                return "Translation error!";
        }
        return resultingWord;
    }
}