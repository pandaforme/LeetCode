package _165;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Split = version1.split("\\.");
        String[] version2Split = version2.split("\\.");

        int j = 0;
        while (j < version1Split.length || j < version2Split.length) {
            int version1Value = (j < version1Split.length) ? Integer.valueOf(version1Split[j]) : 0;
            int version2Value = (j < version2Split.length) ? Integer.valueOf(version2Split[j]) : 0;

            if (version1Value > version2Value)
                return 1;
            else if (version1Value < version2Value)
                return -1;

            j++;
        }

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
