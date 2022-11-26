package learning.mjia.leetcode.grind75.firstbadsolution;

public class FirstBadSolutionRecursive extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersion(1, mid);
        } else {
            return firstBadVersion(mid + 1, end);
        }
    }
}
