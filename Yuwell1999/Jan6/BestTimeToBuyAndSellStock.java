package Jan6;

// 121
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > max) { // 股价达到最低和产生最大差价不能在用一天发生
                max = prices[i] - minPrice;
            }
        }

        return max;
    }
}
