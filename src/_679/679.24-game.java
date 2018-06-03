package _679;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            list.add(Double.valueOf(nums[i]));
        }

        return helper(list);
    }

    private Boolean helper(List<Double> list) {
        if (list.isEmpty())
            return false;

        if (list.size() == 1) {
            return Math.abs(24 - list.get(0)) < 0.001;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Double n1 = list.get(i);
                Double n2 = list.get(j);

                list.remove(i);
                list.remove(j - 1);

                list.add(n1 + n2);
                if (helper(list))
                    return true;
                list.remove(list.size() - 1);

                list.add(n1 - n2);
                if (helper(list))
                    return true;
                list.remove(list.size() - 1);

                list.add(n2 - n1);
                if (helper(list))
                    return true;
                list.remove(list.size() - 1);

                list.add(n1 * n2);
                if (helper(list))
                    return true;
                list.remove(list.size() - 1);

                if (n2 != 0d) {
                    list.add(n1 / n2);
                    if (helper(list))
                        return true;
                    list.remove(list.size() - 1);
                }

                if (n1 != 0d) {
                    list.add(n2 / n1);
                    if (helper(list))
                        return true;
                    list.remove(list.size() - 1);
                }

                list.add(i, n1);
                list.add(j, n2);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(new Solution().judgePoint24(new int[]{3, 3, 8, 8}));
    }
}
