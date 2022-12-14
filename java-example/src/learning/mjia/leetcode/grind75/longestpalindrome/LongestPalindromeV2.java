package learning.mjia.leetcode.grind75.longestpalindrome;

public class LongestPalindromeV2 {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }
    public static int longestPalindrome(String s) {
        int result = 0;

        int[] frequency = new int[256];
        char[] sChar = s.toCharArray();
        for (char c: sChar) {
            ++frequency[c];
        }

        for (int freq: frequency) {
            result += 2 * (freq / 2);
        }

        return result == sChar.length ? result : result + 1;
    }
}
