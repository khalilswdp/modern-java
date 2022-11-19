package learning.mjia.leetcode.grind75.firstbadsolution;

public class VersionControl {
    private int toBeGuessed;

    public VersionControl() {

    }
    public VersionControl(int n) {
        this.toBeGuessed = (int) (n * Math.random());
    }
    boolean isBadVersion(int version) {
        return version >= toBeGuessed;
    }
}
