package learning.mjia.leetcode.grind75.maximumsubarray;

public class MaximumSubarrayBasicElegantlyWrittenOn {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max(0, currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
