//import java.util.*;
//
//class Solution {
//    HashMap<String, ArrayList<String>> map = new HashMap<>();// Neighbors for every node
//    HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node
//
//    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        List<List<String>> res = new ArrayList<>();
//        List<String> solution = new ArrayList<>();
//
//        set.add(start);
//        bfs(start, end, set);
//        dfs(start, end, solution, res);
//        return res;
//    }
//
//    // BFS: Trace every node's distance from the start node (level by level).
//    private void bfs(String start, String end, Set<String> set) {
//        for (String s : set)
//            map.put(s, new ArrayList<>());
//
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(start);
//        distance.put(start, 0);
//
//        while (!queue.isEmpty()) {
//            int count = queue.size();
//
//            boolean foundEnd = false;
//
//            for (int i = 0; i < count; i++) {
//                String current = queue.poll();
//                int currentDistance = distance.get(current);
//
//                for (String word : getWords(current, set)) {
//                    map.get(current).add(word);
//
//                    if (!distance.containsKey(word)) {// Check if visited
//                        distance.put(word, currentDistance + 1);
//                        if (end.equals(word))// Found the shortest path
//                            foundEnd = true;
//                        else
//                            queue.offer(word);
//                    }
//                }
//            }
//
//            if (foundEnd)
//                break;
//        }
//    }
//
//    private List<String> getWords(String s, Set<String> set) {
//        List<String> result = new ArrayList<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            StringBuilder builder = new StringBuilder(s);
//
//            for (char c = 'a'; c <= 'z'; c++) {
//                builder.setCharAt(i, c);
//                String tmp = builder.toString();
//
//                if (tmp.equals(s))
//                    continue;
//
//                if (set.contains(tmp)) {
//                    result.add(tmp);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    // DFS: output all paths with the shortest distance.
//    private void dfs(String cur, String end, List<String> solution, List<List<String>> res) {
//        if (end.equals(cur)) {
//            List<String> list = new ArrayList<>(solution);
//            list.add(cur);
//            res.add(list);
//        } else {
//            for (String next : map.get(cur)) {
//                if (distance.get(next) == distance.get(cur) + 1) {
//                    List<String> list = new ArrayList<>(solution);
//                    list.add(cur);
//                    dfs(next, end, list, res);
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
//        System.out.println(new Solution().findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
//    }
//}