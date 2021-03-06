package main.java.ru.dmzhg;

/**
 * Created by DMZHG on 11.12.2015.
 */
public class CurrencyToWordInterpreter {
    static int suffixNumber;
    private static String[] triadDefinition = new String[]{"копе", "рубл", "тысяч", "миллион", "миллиард"};
    private static String[][] triadSuffix = {
            {"ек ", "йка ", "йки ", "йки ", "йки ", "ек ", "ек ", "ек ", "ек ", "ек "},
            {"ей ", "ь ", "я ", "я ", "я ", "ей ", "ей ", "ей ", "ей ", "ей "},
            {" ", "а ", "и ", "и ", "и ", "", "", "", "", ""},
            {" ", "а ", "а ", "а ", "ов ", "ов ", "ов ", "ов ", "ов "},
            {" ", "а ", "а ", "а ", "ов ", "ов ", "ов ", "ов ", "ов "},
    };

    public static String convert(Double number) {

        String completeNumberWordResult = "";
        int intNumberLength;
        int groupCount;

        String separatedNumberGroup;
        String intNumberString = Integer.toString(number.intValue());
        intNumberLength = Integer.toString(number.intValue()).length();
        String fractionalString = String.valueOf(Integer.parseInt(number.toString().split("\\.")[1]));

        String fractionalResultString = checkSecondNumber(fractionalString, 0);
        if (number.intValue() == 0) {
            completeNumberWordResult =
        }

        if (intNumberLength % 3 == 0) {
            groupCount = intNumberLength / 3;
        } else {
            groupCount = (intNumberLength / 3) + 1;
        }
        for (int i = 0; i < groupCount; i++) {
            if (intNumberString.length() <= 3) {
                separatedNumberGroup = intNumberString;
            } else {
                separatedNumberGroup = intNumberString.substring(intNumberString.length() - 3, intNumberString.length());
                intNumberString = intNumberString.substring(0, intNumberString.length() - 3);
            }
            switch (separatedNumberGroup.length()) {
                case 1:
                    completeNumberWordResult = retrieveRightNumberAsWord(separatedNumberGroup, i + 1) + completeNumberWordResult;
                    break;
                case 2:
                    completeNumberWordResult = checkSecondNumber(separatedNumberGroup, i + 1) + completeNumberWordResult;
                    break;
                case 3:
                    completeNumberWordResult = retrieveRightNumberAsWord(separatedNumberGroup, i + 1) +
                            checkSecondNumber(separatedNumberGroup.substring(1), i + 1) + completeNumberWordResult;
                    break;
                default:
                    return "";
            }
        }
        completeNumberWordResult += fractionalResultString;
        System.out.println(completeNumberWordResult);
        return completeNumberWordResult;
    }

    private static String retrieveRightNumberAsWord(String numberString, int currentGroupCount) {
        String resultingWord = "";
        if (numberString.length() == 3) {
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
                    if (currentGroupCount == 0) {
                        resultingWord = "одна ";
                        suffixNumber = 1;
                        break;
                    }
                    if (currentGroupCount == 2) {
                        resultingWord = "одна ";
                        suffixNumber = 1;
                        break;
                    } else {
                        resultingWord = "один ";
                        break;
                    }

                case '2':
                    if (currentGroupCount == 0) {
                        resultingWord = "две ";
                        suffixNumber = 2;
                        break;
                    }
                    if (currentGroupCount == 2) {
                        resultingWord = "две ";
                        suffixNumber = 2;
                        break;
                    } else {
                        resultingWord = "два ";
                        break;
                    }
                case '3':
                    resultingWord = "три ";
                    suffixNumber = 3;
                    break;
                case '4':
                    resultingWord = "четыре ";
                    suffixNumber = 4;
                    break;
                case '5':
                    resultingWord = "пять ";
                    suffixNumber = 5;
                    break;
                case '6':
                    resultingWord = "шесть ";
                    suffixNumber = 6;
                    break;
                case '7':
                    resultingWord = "семь ";
                    suffixNumber = 7;
                    break;
                case '8':
                    resultingWord = "восемь ";
                    suffixNumber = 8;
                    break;
                case '9':
                    resultingWord = "девять ";
                    suffixNumber = 9;
                    break;
                case '0':
                    resultingWord = "";
                    suffixNumber = 0;
                    break;
                default:
                    return "Translation error!";
            }

        }

        return resultingWord + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][suffixNumber];
    }

    private static String checkSecondNumber(String numberString, int currentGroupCount) {
        String resultingWord;

        int integerNumber = Integer.valueOf(numberString);
        if (integerNumber < 20) {
            if (numberString.charAt(0) == '0') {
                if (numberString.length() < 2) {
                    suffixNumber = 0;
                    resultingWord = "ноль " + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][suffixNumber];
                    return resultingWord;
                }
                resultingWord = retrieveRightNumberAsWord(numberString.substring(1), currentGroupCount);
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
            suffixNumber = 0;
            return resultingWord + triadDefinition[currentGroupCount] + triadSuffix[currentGroupCount][suffixNumber];
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
            resultingWord += retrieveRightNumberAsWord(numberString.substring(1), currentGroupCount);
        }

        return resultingWord;
    }
}