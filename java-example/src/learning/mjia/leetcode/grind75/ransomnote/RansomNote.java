package learning.mjia.leetcode.grind75.ransomnote;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Read more about the other proposed solutions

        // These could also be a map of key to number of occurrences
        char[] ransomNoteChars = new char[26];
        char[] magazineChars = new char[26];

        for (char one: ransomNote.toCharArray()) {
            ransomNoteChars[one - 'a'] += 1;
        }

        for (char one: magazine.toCharArray()) {
            magazineChars[one - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (ransomNoteChars[i] > magazineChars[i]) {
                return false;
            }
        }
        return true;
    }
}
