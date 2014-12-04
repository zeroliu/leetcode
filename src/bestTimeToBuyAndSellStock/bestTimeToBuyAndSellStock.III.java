public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) { return 0; }
        int l = prices.length;
        int[] forward = new int[l];    
        int[] backward = new int[l];
        int max = 0;
        
        int minBuyIn = prices[0];
        forward[0] = 0;
        for (int i=1; i<l; i++) {
            forward[i] = Math.max(forward[i-1], prices[i]-minBuyIn);
            if (minBuyIn > prices[i]) {
                minBuyIn = prices[i];
            }
        }
        
        int maxSell = prices[l-1];
        backward[l-1] = 0;
        for (int i=l-2; i>=0; i--) {
            backward[i] = Math.max(backward[i+1], maxSell-prices[i]);
            if (maxSell < prices[i]) {
                maxSell = prices[i];
            }
        }
        
        for (int i=0; i<l; i++) {
            max = Math.max(max, forward[i]+backward[i]);
        }
        
        return max;
    }
}