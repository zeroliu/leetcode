package stringToIntegerAtoi;

/**
 * Created by zeroliu on 10/26/14.
 */
public class stringToIntegerAtoi {
    public int atoi(String str) {
        //ascii for 0-9 is 48-57
        int zeroAscii = (int)'0';
        int spaceAscii = (int)' ';
        int minusSign = (int)'-';
        int plusSign = (int)'+';

        char[] chars = str.toCharArray();
        boolean started = false;
        boolean signFound = false;
        int sign = 1;
        int result = 0;
        for (int i=0; i<chars.length; i++) {
            int charAscii = (int)chars[i];
            if (charAscii == spaceAscii) {
                if (started) {
                    break;
                }
            } else if (charAscii == minusSign || charAscii == plusSign) {
                if (started || signFound) {
                    break;
                } else {
                    started = true;
                    signFound = true;
                    sign = (charAscii == minusSign) ? -1 : 1;
                }
            } else {
                int diff = charAscii - zeroAscii;
                if (diff >= 0 && diff <= 9) {
                    started = true;
                    if (sign > 0) {
                        if (result > (Integer.MAX_VALUE - diff) / 10) {
                            return Integer.MAX_VALUE;
                        }
                    } else if (sign < 0) {
                        if (-result < (Integer.MIN_VALUE + diff) / 10) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    result = result * 10 + diff;
                } else {
                    break;
                }
            }
        }
        return result * sign;
    }
}
