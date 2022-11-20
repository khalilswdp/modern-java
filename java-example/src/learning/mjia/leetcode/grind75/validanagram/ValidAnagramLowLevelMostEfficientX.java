package learning.mjia.leetcode.grind75.validanagram;

public class ValidAnagramLowLevelMostEfficientX {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        if (sLength != tLength) {
            return false;
        }
        char[] sChars = s.toCharArray(), tChars = t.toCharArray();

        int[] characters = new int[26]; // to be changed to fit all unicode characters

        for (int i = 0; i < sLength; i++) {
            characters[sChars[i] - 'a']++;
            characters[tChars[i] - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (characters[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
