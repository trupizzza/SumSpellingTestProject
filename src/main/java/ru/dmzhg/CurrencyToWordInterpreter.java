package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class CurrencyToWordInterpreter {
    private static String[] triadDefinition = new String[]{"", "тысяч", "миллион", "миллиард"};
    private static String[][] triadSuffix = new String[][]{{"", ""}, {"", "а"}, {"", "я"}, {"", "я"}, {"", "я"}, {"", "ей"}, {"", "ей"}, {"", "ей"}, {"", "ей"}, {"", "ей"}};

    public static String convert(Double number) {
        String completeNumberWordResult = "";
        int intNumberLength;
        int groupCount;
        String triadSuffix = " ";
        String[] separatedNumberGroupsStrings;
        String numberString = number.toString();
        String intNumberString = Integer.toString(number.intValue());
        intNumberLength = Integer.toString(number.intValue()).length();
        String fractionalString = String.valueOf(Integer.parseInt(numberString.split("\\.")[1]));
        String fractionalResultString = checkSecondNumber(fractionalString, 0) + "копеек";

        if (fractionalString.equals("0") & intNumberString.equals("0")) {
            return "ноль ";
        }
        if (intNumberLength % 3 == 0) {
            groupCount = intNumberLength / 3;
        } else {
            groupCount = (intNumberLength / 3) + 1;
        }
        separatedNumberGroupsStrings = new String[groupCount];

        if (intNumberString.equals("0")) {

            completeNumberWordResult = "ноль " + fractionalResultString;
        }
        for (int i = 0; i < groupCount; i++) {
            if (intNumberString.length() <= 3) {
                separatedNumberGroupsStrings[i] = intNumberString;
            } else {
                separatedNumberGroupsStrings[i] = intNumberString.substring(intNumberString.length() - 3, intNumberString.length());
                intNumberString = intNumberString.substring(0, intNumberString.length() - 3);
            }
        }
        for (int i = 0; i < groupCount; i++) {
            switch (separatedNumberGroupsStrings[i].length()) {
                case 1:

                    completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i], i) + triadDefinition[i] + triadSuffix + completeNumberWordResult;
                    break;
                case 2:
                    completeNumberWordResult = checkSecondNumber(separatedNumberGroupsStrings[i], i) + triadDefinition[i] + triadSuffix + completeNumberWordResult;
                    break;
                //TODO: we really need such structure just because of hundreds or we can make it easier?
                case 3:
                    if (checkFirstNumber(separatedNumberGroupsStrings[i], i).equals("")) {
                        completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i], i) +
                                checkSecondNumber(separatedNumberGroupsStrings[i].substring(1), i) + triadDefinition[i] + triadSuffix + completeNumberWordResult;
                    } else {
                        completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i], i) + "сотен " +
                                checkSecondNumber(separatedNumberGroupsStrings[i].substring(1), i) + triadDefinition[i] + triadSuffix + completeNumberWordResult;
                    }
                    break;
                default:
                    return "";
            }
            if (i == separatedNumberGroupsStrings.length - 1) {
                completeNumberWordResult += "рублей " + fractionalResultString;
            }

        }
        return completeNumberWordResult;
    }

    private static String checkFirstNumber(String numberString, int currentGroupCount) {
        String resultingWord;
        switch (numberString.charAt(0)) {
            case '1':
                if (currentGroupCount == 1) {
                    resultingWord = "одна " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][1];
                    break;
                } else {
                    resultingWord = "один ";
                    break;
                }

            case '2':
                if (currentGroupCount == 1) {
                    resultingWord = "две ";
                    break;
                } else {
                    resultingWord = "два ";
                    break;
                }
            case '3':
                resultingWord = "три ";
                break;
            case '4':
                resultingWord = "четыре ";
                break;
            case '5':
                resultingWord = "пять ";
                break;
            case '6':
                resultingWord = "шесть ";
                break;
            case '7':
                resultingWord = "семь ";
                break;
            case '8':
                resultingWord = "восемь ";
                break;
            case '9':
                resultingWord = "девять ";
                break;
            case '0':
                resultingWord = "";
                break;
            default:
                return "Translation error!";
        }
        return resultingWord;
    }

    private static String checkSecondNumber(String numberString, int currentGroupCount) {
        String resultingWord = "";
        int integerNumber = Integer.valueOf(numberString);
        if (integerNumber < 20) {
            if (numberString.charAt(0) == '0') {
                if (numberString.length() < 2) {
                    resultingWord = "ноль ";
                    return resultingWord;
                }
                resultingWord = checkFirstNumber(numberString.substring(1), currentGroupCount);
                return resultingWord;
            }
            switch (integerNumber) {
                case 10:
                    resultingWord = "десять ";
                    break;
                case 11:
                    resultingWord = "одиннадцать ";
                    break;
                case 12:
                    resultingWord = "двенадцать ";
                    break;
                case 13:
                    resultingWord = "тринадцать ";
                    break;
                case 14:
                    resultingWord = "четырнадцать ";
                    break;
                case 15:
                    resultingWord = "пятнадцать ";
                    break;
                case 16:
                    resultingWord = "шестандцать ";
                    break;
                case 17:
                    resultingWord = "семнадцать ";
                    break;
                case 18:
                    resultingWord = "восемнадцать ";
                    break;
                case 19:
                    resultingWord = "девятнадцать ";
                    break;
                case 00:
                    resultingWord = "";
                    break;
                default:
                    resultingWord = "Translation error!";
                    break;
            }
            return resultingWord;
        } else {
            switch (numberString.charAt(0)) {
                case '2':
                    resultingWord = "двадцать ";
                    break;
                case '3':
                    resultingWord = "тридцать ";
                    break;
                case '4':
                    resultingWord = "сорок ";
                    break;
                case '5':
                    resultingWord = "пятьдесят ";
                    break;
                case '6':
                    resultingWord = "шестьдесят ";
                    break;
                case '7':
                    resultingWord = "семьдесят ";
                    break;
                case '8':
                    resultingWord = "восемьдесят ";
                    break;
                case '9':
                    resultingWord = "девяносто ";
                    break;
                default:
                    return "Translation error!";
            }
            resultingWord += checkFirstNumber(numberString.substring(1), currentGroupCount);
        }
        return resultingWord;
    }
}