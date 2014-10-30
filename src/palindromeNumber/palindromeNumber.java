package palindromeNumber;

/**
 * Created by zeroliu on 10/26/14.
 */
public class palindromeNumber {
    public boolean isPalindrome(int x) {
        int palindromeNum = 0;
        int num = x;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            palindromeNum = palindromeNum * 10 + digit;
        }

        return palindromeNum == num;
    }
}
