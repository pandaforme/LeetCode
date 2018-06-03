package _207;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0)
            return true;

        int[][] adjacentMatrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            adjacentMatrix[start][end] = 1;
        }

        for (int i = 0; i < indegree.length; i++) {
            for (int j = 0; j < adjacentMatrix.length; j++) {
                if (adjacentMatrix[j][i] == 1)
                    indegree[i]++;
            }
        }


//        return dfs(adjacentMatrix, indegree);
        return bfs(adjacentMatrix, indegree);

    }

    private boolean bfs(int[][] adjacentMatrix, int[] indegree) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                indegree[i] = -1;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();


            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 0; j < adjacentMatrix[0].length; j++) {
                    if (adjacentMatrix[poll][j] == 1)
                        indegree[j]--;
                }
            }

            for (int i = 0; i < indegree.length; i++) {
                if (indegree[i] == 0) {
                    indegree[i] = -1;
                    queue.add(i);
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != -1)
                return false;
        }

        return true;
    }

    private boolean dfs(int[][] adjacentMatrix, int[] indegree) {
        boolean isDone = true;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != -1)
                isDone = false;
        }

        if (isDone)
            return true;

        int candidate = -1;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                candidate = i;
                break;
            }
        }

        if (candidate == -1)
            return false;

        for (int i = 0; i < adjacentMatrix[0].length; i++) {
            if (adjacentMatrix[candidate][i] == 1) {
                indegree[i]--;
            }
        }

        indegree[candidate] = -1;

        return dfs(adjacentMatrix, indegree);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(3, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0}
        }));

        System.out.println(new Solution().canFinish(2, new int[][]{
                new int[]{1, 0}
        }));

        System.out.println(new Solution().canFinish(2, new int[][]{
                new int[]{1, 0},
                new int[]{0, 1}
        }));
    }
}
