package Jan6;

// 122
class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        // 收集每一段利润
        // 不能反应实际交易
        // 如，若股票一直在涨，第一天买入，第四天卖出，实际上只交易了一次，但此算法认为交易了三次
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] - prices[i] >= 0) {
                max += prices[i + 1] - prices[i];
            }
        }

        return max;
    }
}
