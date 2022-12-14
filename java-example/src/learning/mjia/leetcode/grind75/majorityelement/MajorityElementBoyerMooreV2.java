package learning.mjia.leetcode.grind75.majorityelement;

public class MajorityElementBoyerMooreV2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }
    public static int majorityElement(int[] nums) {
        // Boyer–Moore majority vote algorithm
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
