package _210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjacentMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];

            adjacentMatrix[start][end] = 1;

            indegree[end]++;
        }

        List<Integer> list = new ArrayList<>();
        dfs(adjacentMatrix, indegree, list);

        if (list.isEmpty() || list.size() != numCourses) {
            return new int[0];
        } else {
            int[] result = new int[numCourses];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

    private void dfs(int[][] adjacentMatrix, int[] indegree, List<Integer> list) {

        boolean isFind = false;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                isFind = true;
                list.add(i);
                indegree[i] = -1;

                for (int j = 0; j < adjacentMatrix.length; j++) {
                    if (adjacentMatrix[i][j] == 1) {
                        indegree[j]--;
                    }
                }
            }
        }

        if (isFind)
            dfs(adjacentMatrix, indegree, list);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOrder(3, new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{1, 2}
        })));

        System.out.println(Arrays.toString(new Solution().findOrder(3, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0}
        })));

        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{
                new int[]{1, 0}
        })));

        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        })));
    }
}
