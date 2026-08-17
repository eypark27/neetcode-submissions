class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowestPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
                continue;
            }

            if (prices[i] - lowestPrice > profit) {
                profit = prices[i] - lowestPrice;
            }
        }

        return profit;
    }
}
