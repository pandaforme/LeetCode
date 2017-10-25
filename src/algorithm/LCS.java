package algorithm;

public class LCS {
    public int lcs(String s1, String s2) {
        if (s1 == null || s1.length() == 0)
            return 0;

        if (s2 == null || s2.length() == 0)
            return 0;

        if (s1.charAt(s1.length() - 1) == s2.charAt(s2.length() - 1))
            return lcs(s1.substring(0, s1.length() - 1), s2.substring(0, s2.length() - 1)) + 1;

        return Math.max(lcs(s1, s2.substring(0, s2.length() - 1)), lcs(s1.substring(0, s1.length() - 1), s2));
    }

    int[][] print;

    public int lcsWithDp(String s1, String s2) {
        int[][] tmp = new int[s1.length() + 1][s2.length() + 1];
        print = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tmp[i][j] = tmp[i - 1][j - 1] + 1;
                    print[i][j] = 0;
                } else if (tmp[i - 1][j] > tmp[i][j - 1]) {
                    tmp[i][j] = tmp[i - 1][j];
                    print[i][j] = 1;
                } else {
                    tmp[i][j] = tmp[i][j - 1];
                    print[i][j] = 2;
                }
            }
        }

        return tmp[s1.length()][s2.length()];
    }

    public void print(String s1, String s2, int x, int y) {
        if (x == 0 || y == 0)
            return;

        if (print[x][y] == 0) {
            print(s1, s2, x - 1, y - 1);
            System.out.println(s1.charAt(x - 1));
        } else if (print[x][y] == 1) {
            print(s1, s2, x - 1, y);
        } else {
            print(s1, s2, x, y - 1);
        }

    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        System.out.println(lcs.lcs("ABCABCBA", "CBABCABCC"));
        System.out.println(lcs.lcsWithDp("ABCABCBA", "CBABCABCC"));
        lcs.print("ABCABCBA", "CBABCABCC", 8, 9);
    }
}
