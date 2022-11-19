package learning.mjia.leetcode.grind75.maximumsubarray;

public class MaximumSubarrayDivideAndConquerOLognX {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        return maxSumInSubArray(nums, 0, nums.length - 1);
    }

    // maxSum such that mid is not part of it (both first ifs)
    private static int maxSumInSubArray(int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        } else if (start == end) {
            return nums[start];
        } else {
            int mid = start + (end - start) / 2;
            return Math.max(maxSumInCrossedArray(nums, start, end, mid),
                    Math.max(maxSumInSubArray(nums, start, mid - 1), maxSumInSubArray(nums, mid + 1, end)));
        }
    }

    // maxSum such that mid is part of it
    private static int maxSumInCrossedArray(int[] nums, int start, int end, int mid) {


        int sum = 0;
        int currentLeftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= start; i--) {
            sum += nums[i];
            currentLeftSum = Math.max(currentLeftSum, sum);
        }

        sum = 0;
        int currentRightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= end; i++) {
            sum += nums[i];
            currentRightSum = Math.max(currentRightSum, sum);
        }

        return Math.max(currentRightSum + currentLeftSum,
                Math.max(currentLeftSum, currentRightSum));
    }
}
