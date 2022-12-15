package learning.mjia.leetcode.grind75.ransomnote;

public class RansomNoteV2X {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] occurrences = new int[26];

        char[] rNChar = ransomNote.toCharArray(), mChar = magazine.toCharArray();

        for (char m: mChar) {
            occurrences[m - 'a']++;
        }

        for (char rN: rNChar) {
            occurrences[rN - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (occurrences[i] < 0) {
                return false;
            }
        }

        return true;

    }
}
