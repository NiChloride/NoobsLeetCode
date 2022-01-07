public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
       //track lowest price before current index
       int lowest = prices[0];
       int profit = 0;
       for (int i=1;i<prices.length;i++)
       {
           if(prices[i] - lowest > profit)
           {
               profit = prices[i] - lowest;
           }

           if(prices[i]<lowest)
           {
               lowest = prices[i];
           }
       }

       return profit;

    }
}