package learning.mjia.leetcode.grind75.validpalindrome;

public class ValidPalindromeLowLevelEfficient {
    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            char cLeft = s.charAt(left);
            while (!isAlphaNumeric(cLeft) && left < right) {
                left++;
                cLeft = s.charAt(left);
            }
            char cRight = s.charAt(right);
            while (!isAlphaNumeric(cRight) && left < right) {
                right--;
                cRight = s.charAt(right);
            }

            if (!isAlphaNumericsEqual(cLeft, cRight)) {
                return false;
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
