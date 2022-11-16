package learning.mjia.leetcode.grind75.maximumsubarray;

public class MaximumSubarrayBruteForceUnacceptedOn2 {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        int maximumSum = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                if (currentSum > maximumSum) {
                    maximumSum = currentSum;
                }
            }
        }
        return maximumSum;
    }
}
