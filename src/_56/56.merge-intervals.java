package _56;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 * int start;
 * int end;
 * Interval() { start = 0; end = 0; }
 * Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() == 0 || intervals.size() == 1)
            return intervals;

        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval merge = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (isOverlap(merge, intervals.get(i))) {
                merge = new Interval(
                        Math.min(merge.start, intervals.get(i).start),
                        Math.max(merge.end, intervals.get(i).end));
            } else {
                result.add(merge);
                merge = intervals.get(i);
            }
        }
        result.add(merge);

        return result;
    }

    private boolean isOverlap(Interval interval1, Interval interval2) {
        return interval1.start <= interval2.end && interval2.start <= interval1.end;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().merge(Arrays.asList(new Interval(1, 3))));
        System.out.println(new Solution().merge(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18))));
        System.out.println(new Solution().merge(Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(4, 100), new Interval(15, 18), new Interval(300, 200))));
        System.out.println(new Solution().merge(Arrays.asList(new Interval(1, 4), new Interval(4, 5))));
        System.out.println(new Solution().merge(Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 7), new Interval(8, 9), new Interval(1, 10))));
    }
}
