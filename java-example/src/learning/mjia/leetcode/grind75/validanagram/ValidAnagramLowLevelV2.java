package learning.mjia.leetcode.grind75.validanagram;

import java.util.Arrays;

public class ValidAnagramLowLevelV2 {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int sLength = s.length();
        int tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        for (int i = 0; i < sLength; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }

        return true;
    }
}
