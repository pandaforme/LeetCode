package interview.easy;

class VersionControl {
    boolean isBadVersion(int version) {
        if (version >= 1702766719)
            return true;
        else
            return false;
    }
}

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return (int) helper(1, n);
    }

    private long helper(long start, long end) {
        if (start > end)
            return -1;

        long middle = (start + end) / 2;
        boolean badVersion = isBadVersion((int) middle);
        if (badVersion && !isBadVersion((int) (middle - 1))) {
            return middle;
        } else if (badVersion) {
            return helper(start, middle - 1);
        } else {
            return helper(middle + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
}
