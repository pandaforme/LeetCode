package _278;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import datastructure.VersionControl;

class Solution implements VersionControl {
    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    private int helper(long start, long end) {
        long middle = (start + end) / 2;

        if (start == end)
            return (int) start;

        if (!isBadVersion((int) middle))
            return helper(middle + 1, end);
        else
            return helper(start, middle);
    }

    @Override
    public boolean isBadVersion(int version) {
        return false;
    }
}
