package _56;

import datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
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
        if (intervals == null || intervals.isEmpty())
            return new ArrayList<>();

        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));

        List<Interval> result = new ArrayList<>();

        Interval start = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (isOverlap(start, intervals.get(i))) {
                start = new Interval(Math.min(start.start, intervals.get(i).start),
                        Math.max(start.end, intervals.get(i).end));
            } else {
                result.add(start);
                start = intervals.get(i);
            }
        }

        result.add(start);
        return result;
    }

    private boolean isOverlap(Interval i1, Interval i2) {
        if (i1.start <= i2.end && i2.start <= i1.end)
            return true;

        return false;
    }
}
