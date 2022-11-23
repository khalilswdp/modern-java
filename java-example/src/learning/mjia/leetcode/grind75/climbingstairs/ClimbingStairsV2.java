package learning.mjia.leetcode.grind75.climbingstairs;

public class ClimbingStairsV2 {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int left, right;
        left = 1;
        right = 1;
        int result = left + right;
        for (int i = 1; i < n; i++) {
            result = left + right;
            left = right;
            right = result;
        }
        return result;
    }
}
