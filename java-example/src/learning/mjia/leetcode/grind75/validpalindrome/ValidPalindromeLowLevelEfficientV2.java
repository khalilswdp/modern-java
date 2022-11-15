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
            } else if (!(chars[right] == chars[left] || chars[right] == Character.toLowerCase(chars[left]) || chars[left] == Character.toLowerCase(chars[right]))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char character) {
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') || (character >= '0' && character <= '9');
    }
}
