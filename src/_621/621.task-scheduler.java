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

        Map.Entry<Character, Integer> maxEntry = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxEntry.getValue()))
                count++;
        }

        return Math.max(tasks.length, (maxEntry.getValue() - 1) * (1 + n) + count);
    }
}
