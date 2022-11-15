package learning.mjia.leetcode.grind75.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int currentMaxProfit = 0;
        int days = prices.length;
        int start = 0, end = 1;
        while (end < days) {
            if (prices[end] > prices[start]) {
                int currentProfit = prices[end] - prices[start];
                if (currentProfit > currentMaxProfit) {
                    currentMaxProfit = currentProfit;
                }
            } else {
                start = end;
            }
            end++;
        }
        return currentMaxProfit;
    }
}
