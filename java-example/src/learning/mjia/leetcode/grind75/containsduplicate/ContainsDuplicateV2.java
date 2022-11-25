package learning.mjia.leetcode.grind75.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateV2 {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> count = new HashSet<>();
        for (int num: nums) {
            if (count.contains(num)) {
                return true;
            }
            count.add(num);
        }

        return false;
    }
}
