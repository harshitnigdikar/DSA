package dsa.leetcode.blind75;

public class LC121BestTImeToBuySellStock {
    public int maxProfit(int[] prices) {
        //[7,1,5,3,6,4]

        int maxProfit = 0;
        int buyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - buyPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
