public class Solution {
    public int divide(int dividend, int divisor) {
        long dvd = dividend;
        long dvs = divisor;
        int sign = 1;
        if (dvd < 0){
            sign = -sign;
            dvd = -dvd;
        }
        if (dvs < 0){
            sign = -sign;
            dvs = -dvs;
        }
        
        long[] dict = new long[32];
        long buffer = dvs;
        int i = 0;
        while (dvd >= buffer) {
            dict[i] = buffer;
            i++;
            buffer += buffer;
        }
        
        int result = 0;
        for (int index=i-1; index>=0; index--) {
            if (dict[index] <= dvd) {
                result += 1<<index;
                dvd -= dict[index];
            }
        }
        return result * sign;
    }
}
