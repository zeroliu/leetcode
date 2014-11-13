public class Solution {
    public int sqrt(int x) {
        double last = 0;
        double result = 1;
        double error = 1e-10;
        while (Math.abs(last-result) > error) {
            last = result;
            result = (result + x/result)/2;
        }
        return (int)result;
    }
}
