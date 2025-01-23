class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        int n = prices.length;
        for(int i=1;i<n;i++)
        {
            int cost = prices[i] - minPrice;
            profit = Math.max(profit,cost);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return profit;
    }
}