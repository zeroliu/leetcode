public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[][] cache = new int[l2][];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<l2; i++) {
            cache[i] = new int[l1+l2];
            int incrementor = 0;
            int lowerNum = num2.charAt(l2-i-1) - '0';
            for (int j=0; j<l1; j++) {
                int upperNum = num1.charAt(l1-j-1) - '0';
                int product = lowerNum * upperNum + incrementor;
                cache[i][j+i] = product % 10;
                incrementor = product / 10;
            }
            if (incrementor > 0) {
                cache[i][i+l1] = incrementor;
            }
        }
        int incrementor = 0;
        int sum = incrementor;
        for (int i=0; i<l1+l2; i++) {
            sum = incrementor;
            for (int j=0; j<l2; j++) {
                sum += cache[j][i];
            }
            sb.insert(0, sum%10);
            incrementor = sum/10;
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
