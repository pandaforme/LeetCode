package oa.apple;

//Given an integer sequence s = (s1,s2,s3,...,sn), a subsequence is another sequence s_ = (s_1, s_2, s_3...., s_k) with k < n, and s_1, s_2, s_3..., s_k belonging to s, exactly in that order.
//Find the maximum length of a subsequence in which its elements are in increasing sorted order, lowest to highest.
//The subsequence doesn't have to be necessarily contigous, or unique.
public class Test1 {
    public static int run(int[] sequence) {
        /*
         * Some work here; return type and arguments should be according to the problem's requirements
         */
        int k = 0;
        for (int i = 0; i < sequence.length; i++) {
            int max = helper(sequence[i], i + 1, sequence.length - 1, sequence) + 1;
            k = Math.max(k, max);

            if (sequence.length - i + 1 < max)
                break;
        }

        return k;
    }

    private static Integer helper(int current, int start, int end, int[] sequence) {
        if (start > end) {
            return 0;
        }

        int max = 0;
        for (int i = start; i <= end; i++) {
            if (sequence[i] > current) {
                max = Math.max(max, 1 + helper(sequence[i], i, end, sequence));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Test1.run(new int[]{1000000000, 22, 9, 33, 21, 50, 41, 60, 80, 90, 90, 100, 103, 108, 105}) == 9);
        System.out.println(Test1.run(new int[]{5, 19, 5, 81, 50, 28, 29, 1, 83, 23}) == 5);
        System.out.println(Test1.run(new int[]{1, 0, 2, 6, 3, 4, 5, 11, 12, 13}) == 8);
        System.out.println(Test1.run(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}) == 6);

        System.out.println(Test1.run(new int[]{2, 3, 2, 2, 2, 4, 5}));
        System.out.println(Test1.run(new int[]{1, 1, 1}));
        System.out.println(Test1.run(new int[]{6, 5, 4, 3, 2, 1}));
        System.out.println(Test1.run(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(Test1.run(new int[]{1, 9, 8, 2, 7, 6, 3, 5, 4, 4, 3, 2, 5}));
    }
}
