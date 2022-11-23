package learning.mjia.leetcode.grind75.longestpalindrome;

import java.util.Arrays;

public class LongestPalindrome {
    public static void main(String[] args) {
        longestPalindrome("abccccdd");
    }
    public static int longestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        int[] alphabet = new int[128];
        for (int i = 0; i < sChar.length; i++) {
            alphabet[sChar[i]]++;
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
