package learning.mjia.leetcode.grind75.validanagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramLowLevel {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        int sLength = s.length();
        if (sLength != t.length()) {
            return false;
        }

        int end = 'a' + 26;
        int[] characters = new int[end]; // to be changed to fit all unicode characters

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sLength; i++) {
            characters[sChars[i]]++;
            characters[tChars[i]]--;
        }

        for (int i = 'a'; i < end; i++) {
            if (characters[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
