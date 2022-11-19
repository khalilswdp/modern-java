package learning.mjia.leetcode.grind75.firstbadsolution;

public class FirstBadSolution  extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n, mid;
        // The loop is only broken if left = right (according to how we change their values.)
        while (left < right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
