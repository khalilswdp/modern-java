package learning.mjia.leetcode.grind75.ransomnote;

public class RansomNoteV2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] nbOccurrences = new int[26];
        int rNLength = ransomNote.length(), mLength = magazine.length();

        if (rNLength > mLength) {
            return false;
        }

        char[] rNChars = ransomNote.toCharArray(), mChars = magazine.toCharArray();

        for (char m: mChars) {
            nbOccurrences[m - 'a']++;
        }

        for (char rN: rNChars) {
            if (--nbOccurrences[rN - 'a'] < 0) {
                return false;
            }
        }

        return true;

    }
}
