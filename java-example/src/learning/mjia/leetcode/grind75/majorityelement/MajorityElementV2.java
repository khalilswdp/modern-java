package learning.mjia.leetcode.grind75.majorityelement;

public class MajorityElementV2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }
    public static int majorityElement(int[] nums) {
        int result = nums[0], count = 0;
        for (int num: nums) {
            if (result != num) {
                count--;
            }

            if (result == num || count == 0) {
                result = num;
                count++;
            }

        }
        return result;
    }
}
