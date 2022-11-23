package learning.mjia.leetcode.grind75.climbingstairs;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] results = new int[n + 1];
        int i = 0;
        results[n - i] = 1;
        i++;
        results[n - i] = 1;
        i++;
        while (i <= n) {
            int left = results[n - i + 1];
            int right = results[n - i + 2];
            int result = left + right;
            results[n - i] = result;
            i++;
        }
        return results[0];
    }
}
