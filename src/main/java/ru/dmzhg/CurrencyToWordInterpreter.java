package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class CurrencyToWordInterpreter {
    private static String[] triadDefinition = new String[]{"", "тысяч", "миллион", "миллиард"};
    private static String[][] triadSuffix = {
            {"ек ", "йка ", "йки ", "ек "},
            {"", "а ", "и ", ""},
            {"ов ", "", "а ", "ов "},
            {"ов ", "", "а ", "ов "},
    };
    private static String[] kopeckSuffix = new String[]{"ек ", "йка ", "йки ", "йки ", "йки ", "ек ", "ек ", "ек ", "ек ", "ек "};

    public static String convert(Double number) {

        String completeNumberWordResult = "";
        int intNumberLength;
        int groupCount;
        String[] separatedNumberGroupsStrings;
        String numberString = number.toString();
        String intNumberString = Integer.toString(number.intValue());
        intNumberLength = Integer.toString(number.intValue()).length();
        String fractionalString = String.valueOf(Integer.parseInt(numberString.split("\\.")[1]));

        String fractionalResultString = checkSecondNumber(fractionalString, 0);

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

                    completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i], i) + completeNumberWordResult;
                    break;
                case 2:
                    completeNumberWordResult = checkSecondNumber(separatedNumberGroupsStrings[i], i) + completeNumberWordResult;
                    break;
                case 3:
                    completeNumberWordResult = checkFirstNumber(separatedNumberGroupsStrings[i], i) +
                            checkSecondNumber(separatedNumberGroupsStrings[i].substring(1), i) + completeNumberWordResult;
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
        String resultingWord = "";
        if (numberString.length() > 2) {
            switch (numberString.charAt(0)) {
                case '1':
                    resultingWord = "сто ";
                    break;
                case '2':
                    resultingWord = "двести ";
                    break;
                case '3':
                    resultingWord = "триста ";
                    break;
                case '4':
                    resultingWord = "четыреста ";
                    break;
                case '5':
                    resultingWord = "пятьсот ";
                    break;
                case '6':
                    resultingWord = "шестьсот ";
                    break;
                case '7':
                    resultingWord = "семьсот ";
                    break;
                case '8':
                    resultingWord = "восемьсот ";
                    break;
                case '9':
                    resultingWord = "девятьсот ";
            }
            return resultingWord;
        } else {
            switch (numberString.charAt(0)) {
                case '1':
                    if (currentGroupCount == 1) {

                        resultingWord = "одна " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][1];
                        break;
                    } else {
                        resultingWord = "один " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][2];
                        break;
                    }

                case '2':
                    if (currentGroupCount == 1) {
                        resultingWord = "две " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][2];
                        break;
                    } else {
                        resultingWord = "два " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][2];
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

        }

        return resultingWord;
    }

    private static String checkSecondNumber(String numberString, int currentGroupCount) {
        String resultingWord;
        String kopeckWord="";
        if(currentGroupCount==0)
        {
            kopeckWord = "копе"+kopeckSuffix[Character.getNumericValue(numberString.charAt(1))];
        }
        int integerNumber = Integer.valueOf(numberString);
        if (integerNumber < 20) {
            if (numberString.charAt(0) == '0') {
                if (numberString.length() < 2) {
                    resultingWord = "ноль ";
                    return resultingWord+kopeckWord;
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