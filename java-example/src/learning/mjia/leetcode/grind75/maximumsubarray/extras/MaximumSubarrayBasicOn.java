package learning.mjia.leetcode.grind75.maximumsubarray.extras;

public class MaximumSubarrayBasicOn {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Are we going to build on top of what we have or restart from 0
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

        }
        return maxSum;
    }
}
