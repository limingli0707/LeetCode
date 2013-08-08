package BestTimetobuy;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] forwardMax = new int[prices.length];
        int[] backwardMax = new int[prices.length];
        
        int buyPoint = prices[0];
        int sellPoint = prices[0];
        int maxProfit = 0;
        forwardMax[0] = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPoint) {
                buyPoint = prices[i];
            }
            forwardMax[i] = Math.max(prices[i] - buyPoint, forwardMax[i - 1]);
        }
        sellPoint = prices[prices.length - 1];
        backwardMax[prices.length - 1] = 0;
        
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > sellPoint) {
                sellPoint = prices[i];
            }
            backwardMax[i] = Math.max(sellPoint - prices[i], backwardMax[i + 1]);
        }
        
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (forwardMax[i] + backwardMax[i + 1] > max) {
                max = forwardMax[i] + backwardMax[i + 1];
            }
        }
        if (max < Math.max(forwardMax[prices.length - 1], backwardMax[0])) {
            max = Math.max(forwardMax[prices.length - 1], backwardMax[0]);
        }
        return max;
    }
}