package learning.mjia.leetcode.grind75.ransomnote;

public class RansomNoteV3X {
    public boolean canConstruct(String ransomNote, String magazine) {
        // This is more of specific java knowledge
        int[] lastOccurrence = new int[26];

        char[] rNChars = ransomNote.toCharArray();

        for (char rN: rNChars) {
            int index = magazine.indexOf(rN, lastOccurrence[rN - 'a']);
            if (index == -1) {
                return false;
            }
            lastOccurrence[rN - 'a'] = index + 1;
        }
        return true;
    }
}
