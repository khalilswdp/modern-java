package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindromeV2 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int inputLength = chars.length;
        char[] result = new char[inputLength];
        int output = 0;
        for (char one: chars) {
            if ((one >= 'a' && one <= 'z') || (one <= '9' && one >= '0')) {
                result[output] = one;
                output++;
            } else if (one <= 'Z' && one >= 'A') {
                result[output] = Character.toLowerCase(one);
                output++;
            }
        }
        for (int i = 0, j = output - 1; i < output / 2 && i < j; i++, j--) {
            if (result[i] != result[j]) {
                return false;
            }
        }
        return true;
    }
}
