package learning.mjia;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merge = new ArrayList<>(nums1.length + nums2.length);
        int numsCount1 = nums1.length;
        int numsCount2 = nums2.length;
        int i = 0;
        int j = 0;

        int count = 0;
        while (i < numsCount1 && j < numsCount2) {
            if (nums2[j] < nums1[i]) {
                merge.add(nums2[j]);
                j++;
            } else {
                merge.add(nums1[i]);
                i++;
            }
            count++;
        }

        while (i < numsCount1) {
            merge.add(nums1[i]);
            i++;
            count++;
        }

        while (j < numsCount2) {
            merge.add(nums2[j]);
            j++;
            count++;
        }


        // indices are 0 based
        return count % 2 == 0 ? (merge.get(count / 2 - 1) + merge.get(count / 2)) / 2.0 : merge.get(count / 2);
    }
}
