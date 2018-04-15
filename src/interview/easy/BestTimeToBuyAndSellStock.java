package interview.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int start = 0;
        int profit = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[start])
                start = i;
            else {
                profit = Math.max(profit, prices[i] - prices[start]);
            }
        }

        return profit == Integer.MIN_VALUE ? 0 : profit;
    }

    public static void main(String[] args) {
        System.out.println((new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5));
        System.out.println((new BestTimeToBuyAndSellStock().maxProfit(new int[]{7, 6, 4, 3, 1}) == 0));
    }
}
