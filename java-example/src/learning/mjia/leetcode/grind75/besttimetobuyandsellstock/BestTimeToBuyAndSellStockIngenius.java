package learning.mjia.leetcode.grind75.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStockIngenius {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int currentMaxProfit = 0;
        int currentMinPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < currentMinPrice) {
                currentMinPrice = price;
            }
            int currentProfit = price - currentMinPrice;
            if (currentProfit > currentMaxProfit) {
                currentMaxProfit = currentProfit;
            }
        }
        return currentMaxProfit;
    }
}
