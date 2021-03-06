import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            Integer position = map.get(val);

            if (list.get(list.size() - 1) == val) {
                list.remove(list.size() - 1);
                map.remove(val);
            } else {
                int tmp = list.get(list.size() - 1);
                list.set(position, tmp);
                list.remove(list.size() - 1);
                map.put(tmp, position);
                map.remove(val);
            }

            return true;
        }

        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
