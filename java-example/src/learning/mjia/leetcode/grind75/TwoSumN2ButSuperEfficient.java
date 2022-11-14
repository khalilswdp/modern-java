package learning.mjia.leetcode.grind75;

public class TwoSumN2ButSuperEfficient {
    public int[] twoSum(int[] nums, int target) {
        int exclusiveOffset = 0;
        while (exclusiveOffset < nums.length) {
            int startIndex = 0;
            int endIndex = startIndex + exclusiveOffset + 1;
            while (startIndex < nums.length && endIndex < nums.length) {
                if (nums[startIndex] + nums[endIndex] == target) {
                    return new int[] {startIndex, endIndex};
                }
                startIndex++;
                endIndex++;
            }
            exclusiveOffset++;
        }

        return null;
    }
}
