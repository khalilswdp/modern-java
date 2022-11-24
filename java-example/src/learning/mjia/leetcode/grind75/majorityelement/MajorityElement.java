package learning.mjia.leetcode.grind75.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num: nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        for (int occurrence: occurrences.keySet()) {
            if (occurrences.get(occurrence) > (n / 2)) {
                return occurrence;
            }
        }
        return -1;
    }
}
