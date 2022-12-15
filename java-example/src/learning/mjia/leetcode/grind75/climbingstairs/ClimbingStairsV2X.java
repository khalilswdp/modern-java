package learning.mjia.leetcode.grind75.climbingstairs;

public class ClimbingStairsV2X {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int first = 1, second = 2, temp;

        while (n > 2) {
            temp = second;
            second = first + second;
            first = temp;
            n--;
        }

        return second;
    }
}
