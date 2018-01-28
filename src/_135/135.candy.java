package _135;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int candy(int[] ratings) {
        List<Integer> candies = new ArrayList<>(Collections.nCopies(ratings.length, 1));

        // from left to right, find ascending elements
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies.set(i, candies.get(i - 1) + 1);
            }
        }

        // from right to left, find descending elements
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies.get(i) <= candies.get(i + 1)) {
                candies.set(i, candies.get(i + 1) + 1);
            }
        }


        int count = 0;
        for (int i = 0; i < candies.size(); i++) {
            count += candies.get(i);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().candy(new int[]{4, 2, 3, 4, 1}));
    }
}