package _168;

class Solution {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();

        while (n > 0) {
            int r = n % 26;
            r = (r == 0) ? 26 : r;
            String tmp = Character.toString((char) (r + 64));
            s.insert(0, tmp);
            n = (n - r) / 26;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(703));
        System.out.println(new Solution().convertToTitle(52));
        System.out.println(new Solution().convertToTitle(1));
        System.out.println(new Solution().convertToTitle(26));
        System.out.println(new Solution().convertToTitle(28));
        System.out.println(new Solution().convertToTitle(701));
        System.out.println(new Solution().convertToTitle(800));
    }
}
