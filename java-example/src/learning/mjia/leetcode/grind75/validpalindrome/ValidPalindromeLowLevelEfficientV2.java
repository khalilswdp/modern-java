package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindromeLowLevelEfficientV2 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (!isAlphaNumeric(chars[left])) {
                left++;
            } else if (!isAlphaNumeric(chars[right])) {
                right--;
            } else if (!isAlphaNumericsEqual(chars[left], chars[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumericsEqual(char left, char right) {
        return right == left || right == Character.toLowerCase(left) || left == Character.toLowerCase(right);
    }

    private static boolean isAlphaNumeric(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') || (character >= '0' && character <= '9');
    }
}
