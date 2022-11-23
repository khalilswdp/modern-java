package learning.mjia.leetcode.grind75.longestpalindrome;

public class LongestPalindrome {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }
    public static int longestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        int[] alphabet = new int[128];
        for (char currentChar: sChar) {
            alphabet[currentChar]++;
        }

        boolean isThereAnOdd = false;
        int longestBoolean = 0;
        for (int i : alphabet) {
            longestBoolean += 2 * (i / 2);
            if (!isThereAnOdd && (i % 2) != 0) {
                longestBoolean++;
                isThereAnOdd = true;
            }
        }

        return longestBoolean;
    }
}
