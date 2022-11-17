package learning.mjia.leetcode.grind75.maximumsubarray;

public class MaximumSubarrayDivideAndConquerV2On {
    public static void main(String[] args) {
        maxSubArray(new int[]{8,-19,5,-4,20});
    }
    public static int maxSubArray(int[] nums) {
        return findMaximumSubarrayByComparingMSDs(nums, 0, nums.length - 1).maxSum;
    }

    private static MSD findMaximumSubarrayByComparingMSDs(int[] nums, int start, int end) {
        if (start == end) {
            return new MSD(nums[start], nums[start], nums[start], nums[start]);
        } else {
            int mid = start + (end - start) / 2;
            MSD left = findMaximumSubarrayByComparingMSDs(nums, start, mid);
            MSD right = findMaximumSubarrayByComparingMSDs(nums, mid + 1, end);
            return compareMSDs(left, right);
        }
    }

    private static MSD compareMSDs(MSD left, MSD right) {
        int totalSum = left.totalSum + right.totalSum;
        int maxPrefix = Math.max(left.maxPrefix, left.totalSum + right.maxPrefix);
        int maxSuffix = Math.max(right.maxSuffix, right.totalSum + left.maxSuffix);
        int maxSum = Math.max(left.maxSuffix + right.maxPrefix, Math.max(left.maxSum, right.maxSum));

        return new MSD(totalSum, maxSum, maxPrefix, maxSuffix);
    }

    static class MSD {
        public int totalSum, maxSum, maxPrefix, maxSuffix;

        public MSD(int totalSum, int maxSum, int maxPrefix, int maxSuffix) {
            this.totalSum = totalSum;
            this.maxSum = maxSum;
            this.maxPrefix = maxPrefix;
            this.maxSuffix = maxSuffix;
        }
    }
}