package _380;

import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int deleteIndex = map.get(val);

            if (deleteIndex == list.size() - 1) {
                list.remove(deleteIndex);
            } else {
                int lastValue = list.remove(list.size() - 1);
                // move lastValue to deleteIndex
                list.set(deleteIndex, lastValue);
                // update lastValue's index
                map.put(lastValue, deleteIndex);
            }
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int r = random.nextInt(list.size());
        return list.get(r);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(-2));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(-3));
        System.out.println(obj.insert(-2));
        System.out.println(obj.remove(-2));
        System.out.println(obj.remove(3));
        System.out.println(obj.insert(-1));
        System.out.println(obj.remove(-3));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(-2));
        System.out.println(obj.insert(-2));
        System.out.println(obj.insert(-2));
        System.out.println(obj.insert(1));
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(-2));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(-3));
        System.out.println(obj.insert(1));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
