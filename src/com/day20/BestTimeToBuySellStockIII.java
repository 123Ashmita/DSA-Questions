package com.day20;

/**
 * This class provides a solution for the problem:
 * Best Time to Buy and Sell Stock III (at most two transactions).
 * 
 * The goal is to maximize profit by making at most two buy-sell transactions.
 */
public class BestTimeToBuySellStockIII {

    /**
     * Calculates the maximum profit from at most two stock transactions.
     * 
     * @param prices Array where prices[i] is the stock price on day i.
     * @return The maximum profit achievable.
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        // Track max profit after first buy (we spend money, so negative)
        int buy1 = Integer.MIN_VALUE;

        // Track max profit after first sell
        int sell1 = 0;

        // Track max profit after second buy (use profit from first sell)
        int buy2 = Integer.MIN_VALUE;

        // Track max profit after second sell
        int sell2 = 0;

        for (int price : prices) {
            // Update the maximum profit after first buy (maximize negative cost)
            buy1 = Math.max(buy1, -price);

            // Update the maximum profit after first sell
            sell1 = Math.max(sell1, buy1 + price);

            // Update the maximum profit after second buy (subtract profit from first sell)
            buy2 = Math.max(buy2, sell1 - price);

            // Update the maximum profit after second sell
            sell2 = Math.max(sell2, buy2 + price);
        }

        // sell2 contains the max profit after completing two transactions
        return sell2;
    }

    /**
     * Main method to test the maxProfit function.
     */
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(prices));  // Expected output: 6
    }
}
