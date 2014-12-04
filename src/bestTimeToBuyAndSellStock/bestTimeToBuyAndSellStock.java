public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int low = prices[0];
        int high = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            } else if (prices[i] > high) {
                high = prices[i];
                profit = Math.max(high-low, profit);
            }
        }
        return profit;
    }
}