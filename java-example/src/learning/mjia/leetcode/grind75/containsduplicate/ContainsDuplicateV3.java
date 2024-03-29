package learning.mjia.leetcode.grind75.containsduplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateV3 {
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        int previous = nums[0] + 1;
        for (int num: nums) {
            if (previous == num) {
                return true;
            }
            previous = num;
        }

        return false;
    }
}
