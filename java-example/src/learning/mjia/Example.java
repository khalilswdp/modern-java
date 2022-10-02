package learning.mjia;

public class Example {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int numsCount1 = nums1.length;
        int numsCount2 = nums2.length;
        int i = 0;
        int j = 0;

        int count = 0;
        while (i < numsCount1 && j < numsCount2) {
            int firstNumber = nums1[i];
            int secondNumber = nums2[j];
            if (secondNumber < firstNumber) {
                merge[count] = secondNumber;
                j++;
            } else {
                merge[count] = firstNumber;
                i++;
            }
            count++;
        }

        while (i < numsCount1) {
            merge[count] = nums1[i];
            i++;
            count++;
        }

        while (j < numsCount2) {
            merge[count] = nums2[j];
            j++;
            count++;
        }


        // indices are 0 based
        return count % 2 == 0 ? (merge[count / 2 - 1] + merge[count / 2]) / 2.0 : merge[count / 2];
    }
}
