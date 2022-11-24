package learning.mjia.leetcode.grind75.majorityelement;

public class MajorityElementV2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }
    public static int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for (int num: nums) {
            if (count == 0) {
                result = num;
            }

            if (result == num) {
                count++;
            } else {
                count--;
            }

        }
        return result;
    }
}
