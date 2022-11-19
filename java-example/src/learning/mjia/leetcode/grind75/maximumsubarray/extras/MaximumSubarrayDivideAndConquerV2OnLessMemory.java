package learning.mjia.leetcode.grind75.maximumsubarray.extras;

public class MaximumSubarrayDivideAndConquerV2OnLessMemory {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        return findMaximumSubarrayByComparingMSDs(nums, 0, nums.length - 1)[1];
    }

    private static int[] findMaximumSubarrayByComparingMSDs(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start], nums[start], nums[start], nums[start] };
        } else {
            int mid = start + (end - start) / 2;
            int[] left = findMaximumSubarrayByComparingMSDs(nums, start, mid);
            int[] right = findMaximumSubarrayByComparingMSDs(nums, mid + 1, end);
            return compareMSDs(left, right);
        }
    }

    private static int[] compareMSDs(int[] left, int[] right) {
        int leftTotalSum = left[0];
        int leftMaxSum = left[1];
        int leftMaxPrefix = left[2];
        int leftMaxSuffix = left[3];
        int rightTotalSum = right[0];
        int rightMaxSum = right[1];
        int rightMaxPrefix = right[2];
        int rightMaxSuffix = right[3];

        int totalSum = leftTotalSum + rightTotalSum;
        int maxSum = Math.max(leftMaxSuffix + rightMaxPrefix, Math.max(leftMaxSum, rightMaxSum));
        int maxPrefix = Math.max(leftMaxPrefix, leftTotalSum + rightMaxPrefix);
        int maxSuffix = Math.max(rightMaxSuffix, rightTotalSum + leftMaxSuffix);

        return new int[] { totalSum, maxSum, maxPrefix, maxSuffix };
    }
}