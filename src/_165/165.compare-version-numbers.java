package _165;

// it is a annoying question, although it is not hard.
// before diving into it, you need to understand its version rule.
// the version can be 1.0/1/1.0.0 ..., although they are the same.
// the best way is convert to number and you don't need to handle cumbersome cases.
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        double result1 = 0;
        int power = 0;
        for (int i = 0; i < split1.length; i++) {
            result1 += Integer.valueOf(split1[i]) * Math.pow(10, power);
            power--;
        }

        double result2 = 0;
        power = 0;
        for (int i = 0; i < split2.length; i++) {
            result2 += Integer.valueOf(split2[i]) * Math.pow(10, power);
            power--;
        }

        if (result1 > result2)
            return 1;
        if (result1 < result2)
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("0.1", "1.1"));
        System.out.println(new Solution().compareVersion("1.1", "1.2"));
        System.out.println(new Solution().compareVersion("01", "1"));
        System.out.println(new Solution().compareVersion("2.0", "2"));
        System.out.println(new Solution().compareVersion("2.1", "2"));
        System.out.println(new Solution().compareVersion("0.9.9.9.9", "1"));
        System.out.println(new Solution().compareVersion("1.0.1", "1"));

    }
}
