package learning.mjia.leetcode.grind75.validanagram;

import java.util.Arrays;

public class ValidAnagramLowLevelV2GoodIdea {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }
}
