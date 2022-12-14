package learning.mjia.leetcode.grind75.majorityelement;

import java.util.Arrays;

public class MajorityElementV3Ingenius {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
