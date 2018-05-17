package _378;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        class Tuple {
            private int x;
            private int y;
            private int value;

            public Tuple(int x, int y, int value) {
                this.x = x;
                this.y = y;
                this.value = value;
            }

            public int getValue() {
                return value;
            }
        }

        int n = matrix.length;

        PriorityQueue<Tuple> queue = new PriorityQueue<>(Comparator.comparingInt(Tuple::getValue));
        for (int i = 0; i < n; i++) {
            queue.offer(new Tuple(0, i, matrix[0][i]));
        }

        Tuple result = null;
        for (int i = 0; i < k; i++) {
            result = queue.poll();
            if (result.x + 1 < n)
                queue.offer(new Tuple(result.x + 1, result.y, matrix[result.x + 1][result.y]));
        }

        return result.value;
    }

//    public int kthSmallest(int[][] matrix, int k) {
//        int n = matrix.length;
//        int low = matrix[0][0];
//        int high = matrix[n - 1][n - 1];
//
//        return helper(matrix, low, high, n, k);
//    }
//
//    private int helper(int[][] matrix, int low, int high, int n, int k) {
//        if(low == high)
//            return low;
//
//        int middle = (low + high) / 2;
//
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] <= middle)
//                    count++;
//            }
//        }
//
//        if (k > count)
//            return helper(matrix, middle + 1, high, n, k);
//        return helper(matrix, low, middle, n, k);
//    }


    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][]{
                new int[]{1, 5, 9},
                new int[]{10, 11, 13},
                new int[]{12, 13, 15}
        }, 8));

        System.out.println(new Solution().kthSmallest(new int[][]{
                new int[]{1, 3, 5},
                new int[]{6, 7, 12},
                new int[]{11, 14, 14}
        }, 7));
    }
}
