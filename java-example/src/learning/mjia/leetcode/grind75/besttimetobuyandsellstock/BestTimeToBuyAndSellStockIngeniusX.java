package learning.mjia.leetcode.grind75.besttimetobuyandsellstock;

public class BestTimeToBuyAndSellStockIngeniusX {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int minStock = prices[0];
        int maxProfit = 0;
        for (int price: prices) {
            minStock = Math.min(minStock, price);
            maxProfit = Math.max(maxProfit, price - minStock);
        }
        return maxProfit;
    }
}
