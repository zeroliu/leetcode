public class Solution {
    public double pow(double x, int n) {
        boolean sign = false;
        if (n < 0) {
            sign = true;
            n = -n;
        }
        double result = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            n >>= 1;
            x *= x;
        }
        return sign ? 1/result : result;
    }
}
