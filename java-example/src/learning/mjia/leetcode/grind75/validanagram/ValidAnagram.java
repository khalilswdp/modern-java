package learning.mjia.leetcode.grind75.validanagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = fill(s), tMap = fill(t);
        if (!(sMap.keySet().equals(tMap.keySet()))) {
            return false;
        }
        for (Character character : sMap.keySet()) {
            if (sMap.get(character).compareTo(tMap.get(character)) != 0) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> fill(String s) {
        Map<Character, Integer> result = new HashMap<>();
        char[] characters = s.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            result.put(characters[i], 1 + result.getOrDefault(characters[i], 0));
        }
        return result;
    }
}
