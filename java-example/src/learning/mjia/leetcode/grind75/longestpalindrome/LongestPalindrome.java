package learning.mjia.leetcode.grind75.longestpalindrome;

public class LongestPalindrome {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }
    public static int longestPalindrome(String s) {
        int result = 0;

        int[] frequency = new int[256];
        for (char c: s.toCharArray()) {
            ++frequency[c];
        }

        for (int freq: frequency) {
            result += 2 * (freq / 2);
            if (result % 2 == 0 && freq % 2 != 0) {
                result++;
            }
        }

        return result;
    }
}
