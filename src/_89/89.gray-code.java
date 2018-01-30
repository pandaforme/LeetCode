package _89;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int element = 0;

        if (n == 0) {
            result.add(element);
            return result;
        }

        List<Integer> list = grayCode(n - 1);
        result.addAll(list);

        int head = 1 << (n - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i) | head);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(3));
    }
}
