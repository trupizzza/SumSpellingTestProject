package main.java.ru.dmzhg;

import java.math.BigDecimal;

public class SummaSpellingOut {
    private static final BigDecimal zero = BigDecimal.ZERO;
    private static final BigDecimal HUNDRED = new BigDecimal("100");
    private static final BigDecimal thousand = new BigDecimal("1000");
    private static String[] suff = {"руб.", "руб.", "руб.", "коп.", "коп.", "коп.", "M"};

    public static String getAmountWithWord(final String originalNumberString) {
        if (originalNumberString == null || originalNumberString.isEmpty()) {
            return "";
        }

        String cleanNumberString = originalNumberString.replace(",", ".").replace(" ", "");
        if (cleanNumberString.matches("[a-zA-Z]+")) {
            return "";
        }

        BigDecimal decimalValue = toBigDecimal(cleanNumberString);

        decimalValue = decimalValue.multiply(new BigDecimal(100.0D));

        return spellNumber(decimalValue);
    }

    private static BigDecimal toBigDecimal(String cleanNumberString) {
        BigDecimal converted = BigDecimal.ZERO;
        try {
            converted = new BigDecimal(cleanNumberString);

        } catch (NumberFormatException x) {
            //ignore
        }
        return converted;

    }

    public static String getRightPart(BigDecimal decimalNumber) {
        return alignSumm(decimalNumber.remainder(HUNDRED).abs().toString());
    }

    static String alignSumm(String s) {
        switch (s.length()) {
            case 0:
                s = "00";
                break;
            case 1:
                s = "0" + s;
        }
        return s;
    }

    private static String spellNumber(final BigDecimal decimalValue) {

        StringBuffer result = new StringBuffer();
        BigDecimal[] divrem = decimalValue.divideAndRemainder(HUNDRED);
        if (divrem[0].signum() == 0) {
            result.append("Ќоль ");
        }
        divrem = divrem[0].divideAndRemainder(thousand);
        BigDecimal quotient = divrem[0];
        BigDecimal remainder = divrem[1];
        int group = 0;
        do {
            int value = remainder.intValue();
            result.insert(0, groupToString(value, group));
            if (group == 0) {
                int rank10 = value % 100 / 10;
                int rank = value % 10;
                if (rank10 == 1) {
                    result = result.append(suff[2]);
                } else {
                    switch (rank) {
                        case 1:
                            result = result.append(suff[0]);
                            break;
                        case 2:
                        case 3:
                        case 4:
                            result = result.append(suff[1]);
                            break;
                        default:
                            result = result.append(suff[2]);
                    }
                }
            }
            divrem = quotient.divideAndRemainder(thousand);
            quotient = divrem[0];
            remainder = divrem[1];
            group++;
        } while ((!quotient.equals(zero)) || (!remainder.equals(zero)));
        String s = getRightPart(decimalValue);
        result = result.append(" ").append(s);
        result = result.append(" ");
        if (s.charAt(0) == '1') {
            result = result.append(suff[5]);
        } else {
            switch (s.charAt(1)) {
                case '1':
                    result = result.append(suff[3]);
                    break;
                case '2':
                case '3':
                case '4':
                    result = result.append(suff[4]);
                    break;
                default:
                    result = result.append(suff[5]);
            }
        }
        result.setCharAt(0, Character.toUpperCase(result.charAt(0)));


        return result.toString();
    }

    static String groupToString(int value, int group) {
        if ((value < 0) || (value > 999)) {
            throw new IllegalArgumentException("значеие д.б между 0 и 999 включительно");
        }
        if (group < 0) {
            throw new IllegalArgumentException("группа должна быть больше чем 0");
        }
        StringBuffer result = new StringBuffer(32);
        if (value == 0) {
            return result.toString();
        }
        int rank = value / 100;
        switch (rank) {
            default:
                break;
            case 1:
                result = result.append("сто ");
                break;
            case 2:
                result = result.append("двести ");
                break;
            case 3:
                result = result.append("триста ");
                break;
            case 4:
                result = result.append("четыреста ");
                break;
            case 5:
                result = result.append("пятьсот ");
                break;
            case 6:
                result = result.append("шестьсот ");
                break;
            case 7:
                result = result.append("семьсот ");
                break;
            case 8:
                result = result.append("восемьсот ");
                break;
            case 9:
                result = result.append("девятьсот ");
        }
        rank = value % 100 / 10;
        switch (rank) {
            default:
                break;
            case 2:
                result = result.append("двадцать ");
                break;
            case 3:
                result = result.append("тридцать ");
                break;
            case 4:
                result = result.append("сорок ");
                break;
            case 5:
                result = result.append("пятьдесят ");
                break;
            case 6:
                result = result.append("шестьдесят ");
                break;
            case 7:
                result = result.append("семьдесят ");
                break;
            case 8:
                result = result.append("восемьдесят ");
                break;
            case 9:
                result = result.append("девяносто ");
        }
        int rank10 = rank;
        rank = value % 10;
        if (rank10 == 1) {
            switch (rank) {
                case 0:
                    result = result.append("десять ");
                    break;
                case 1:
                    result = result.append("одиннадцать ");
                    break;
                case 2:
                    result = result.append("двенадцать ");
                    break;
                case 3:
                    result = result.append("тринадцать ");
                    break;
                case 4:
                    result = result.append("четырнадцать ");
                    break;
                case 5:
                    result = result.append("пятнадцать ");
                    break;
                case 6:
                    result = result.append("шестнадцать ");
                    break;
                case 7:
                    result = result.append("семнадцать ");
                    break;
                case 8:
                    result = result.append("восемнадцать ");
                    break;
                case 9:
                    result = result.append("девятнадцать ");
            }
        } else {
            switch (rank) {
                default:
                    break;
                case 1:
                    if (group == 1) {
                        result = result.append("одна ");
                    } else if (suff[6].equals("M")) {
                        result = result.append("один ");
                    }
                    if (suff[6].equals("F")) {
                        result = result.append("одна ");
                    }
                    break;
                case 2:
                    if (group == 1) {
                        result = result.append("две ");
                    } else if (suff[6].equals("M")) {
                        result = result.append("два ");
                    }
                    if (suff[6].equals("F")) {
                        result = result.append("две ");
                    }
                    break;
                case 3:
                    result = result.append("три ");
                    break;
                case 4:
                    result = result.append("четыре ");
                    break;
                case 5:
                    result = result.append("пять ");
                    break;
                case 6:
                    result = result.append("шесть ");
                    break;
                case 7:
                    result = result.append("семь ");
                    break;
                case 8:
                    result = result.append("восемь ");
                    break;
                case 9:
                    result = result.append("девять ");
            }
        }
        switch (group) {
            default:
                break;
            case 1:
                if (rank10 == 1) {
                    result = result.append("тысяч ");
                } else {
                    switch (rank) {
                        default:
                            result = result.append("тысяч ");
                            break;
                        case 1:
                            result = result.append("тысяча ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            result = result.append("тысячи ");
                    }
                }
                break;
            case 2:
                if (rank10 == 1) {
                    result = result.append("миллионов ");
                } else {
                    switch (rank) {
                        default:
                            result = result.append("миллионов ");
                            break;
                        case 1:
                            result = result.append("миллион ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            result = result.append("миллиона ");
                    }
                }
                break;
            case 3:
                if (rank10 == 1) {
                    result = result.append("миллиардов ");
                } else {
                    switch (rank) {
                        default:
                            result = result.append("миллиардов ");
                            break;
                        case 1:
                            result = result.append("миллиард ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            result = result.append("миллиарда ");
                    }
                }
                break;
            case 4:
                if (rank10 == 1) {
                    result = result.append("триллионов ");
                } else {
                    switch (rank) {
                        default:
                            result = result.append("триллионов ");
                            break;
                        case 1:
                            result = result.append("триллион ");
                            break;
                        case 2:
                        case 3:
                        case 4:
                            result = result.append("триллиона ");
                    }
                }
                break;
        }
        return result.toString();
    }
}
