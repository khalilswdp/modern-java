package learning.mjia.leetcode.grind75.longestpalindrome;

public class LongestPalindromeV3 {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }
    public static int longestPalindrome(String s) {

        int[] frequency = new int[256];
        char[] sChar = s.toCharArray();
        for (char c: sChar) {
            ++frequency[c];
        }

        int result = 0, rem = 0;
        for (int freq: frequency) {
            result += freq / 2;
            rem = rem | freq % 2;
            // if (rem == 0) {
            //      rem = freq % 2;
            // }
        }

        return 2 * result + rem;
    }
}
