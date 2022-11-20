package learning.mjia.leetcode.grind75.besttimetobuyandsellstock.extras;

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
                currentMaxProfit = Math.max(currentProfit, currentMaxProfit);
            } else {
                start = end;
            }
            end++;
        }
        return currentMaxProfit;
    }
    // This is the same as the ingenious solution when expressed like this:
    //        int minStock = prices[0];
    //        int maxProfit = 0;
    //        for (int price: prices) {
    //            if (price > minStock) {
    //                maxProfit = Math.max(maxProfit, price - minStock);
    //            } else {
    //                minStock = Math.min(minStock, price);
    //            }
    //        }
    //        return maxProfit;
}
