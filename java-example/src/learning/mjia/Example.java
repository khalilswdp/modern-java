package learning.mjia;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = merge(nums1, nums2);
        int count = merge.length;
        double result = count % 2 == 0 ? (merge[count / 2 - 1] + merge[count / 2]) / 2.0 : merge[count / 2];
        return result;
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        List<Integer> merge = new ArrayList<>(nums1.length + nums2.length);
        int numsCount1 = nums1.length;
        int numsCount2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < numsCount1 && j < numsCount2) {
            if (nums2[j] < nums1[i]) {
                merge.add(nums2[j]);
                j++;
            } else {
                merge.add(nums1[i]);
                i++;
            }
        }

        while (i < numsCount1) {
            merge.add(nums1[i]);
            i++;
        }

        while (j < numsCount2) {
            merge.add(nums2[j]);
            j++;
        }


        return merge.stream().mapToInt(Integer::intValue).toArray();
    }
}
