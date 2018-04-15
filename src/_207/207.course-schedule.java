package _207;

import java.util.ArrayList;
import java.util.List;

class Solution {

    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0)
            return true;

        int[][] matirx = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];

            matirx[start][end] = 1;
            indegree[end]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                list.add(i);
            }
        }

        if (list.size() == 0)
            return false;

        int count = 0;
        for (int i : list) {
            count += helper(matirx, indegree, i) + 1;
        }

        return count == numCourses;
    }

    private int helper(int[][] matirx, int[] indegree, int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < matirx.length; i++) {
            if (matirx[target][i] != 0) {
                indegree[i]--;
                if (indegree[i] == 0)
                    list.add(i);
            }
        }

        int count = 0;
        for (int i : list) {
            count += 1 + helper(matirx, indegree, i);
        }

        return count;
    }

    // bfs
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[][] matirx = new int[numCourses][numCourses];
//        int[] indegree = new int[numCourses];
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int start = prerequisites[i][1];
//            int end = prerequisites[i][0];
//
//            matirx[start][end] = 1;
//            indegree[end]++;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < indegree.length; i++) {
//            if (indegree[i] == 0)
//                queue.offer(i);
//        }
//
//        int count = 0;
//        while (!queue.isEmpty()) {
//            int index = queue.poll();
//            count++;
//
//            for (int i = 0; i < numCourses; i++) {
//                if (matirx[index][i] != 0) {
//                    indegree[i]--;
//                    if (indegree[i] == 0)
//                        queue.offer(i);
//                }
//            }
//        }
//
//        return count == numCourses;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(3, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0}
        }));

        System.out.println(new Solution().canFinish(3, new int[][]{
                new int[]{1, 0}
        }));

        System.out.println(new Solution().canFinish(2, new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        }));
    }
}
