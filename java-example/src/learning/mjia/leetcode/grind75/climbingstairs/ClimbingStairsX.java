package learning.mjia.leetcode.grind75.climbingstairs;

public class ClimbingStairsX {
    public int climbStairs(int n) {
        int[] dictionary = new int[n + 2];
        dictionary[1] = 1;
        dictionary[2] = 2;

        int i = 3;
        while (i <= n) {
            dictionary[i] = dictionary[i - 1] + dictionary[i - 2];
            i++;
        }

        return dictionary[n];
    }
}
