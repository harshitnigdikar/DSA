package dsa.leetcode.blind75;

public class LC122BestTimeStock2 {
    public static int maxProfit(int[] prices) {
        // {7,1,5,3,6,4}
        // is sawaal me greedy ye hai ki isme assume kiya hai buy and sell humesha consecutive days me he hoga
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for(int i = 1;i<len; i++){
            if(start < prices[i]){
                max += prices[i] - start;
                System.out.println("i = " + i + ", max = " + max);
            }
            start = prices[i];
            System.out.println(", start = " + start);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("ans = " + maxProfit(prices));
    }
}
