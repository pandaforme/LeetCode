package interview.easy;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5, 3, 2, 4, 6, 8, 3, 6}));
    }
}
