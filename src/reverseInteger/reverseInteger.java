package reverseInteger;

/**
 * Created by zeroliu on 10/26/14.
 */
public class reverseInteger {
    public int reverse(int x) {
        int newNum = 0;
        int sign = (x >= 0) ? 1 : -1;
        x = x * sign;
        while (x > 0) {
            int lastDigit = x % 10;
            x = x / 10;
            newNum = newNum * 10 + lastDigit;
        }

        return newNum * sign;
    }
}
