package _621;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        Map.Entry<Character, Integer> maxEnrty = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxEnrty.getValue())) {
                count++;
            }
        }

        return Math.max(tasks.length, (maxEnrty.getValue() - 1) * (n + 1) + count);
    }
}
